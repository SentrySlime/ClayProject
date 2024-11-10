import { useQuery } from "@tanstack/react-query";
import axios from "axios";

const fetchStatistics = async (userId) => {
  const response = await axios.get(
    `http://localhost:8080/api/data/${userId}`
  );
  return response.data;
};

const Statistics = ({ userId }) => {
  const { data, isLoading, isError, error } = useQuery({
    queryKey: ["statisticsData", userId],
    queryFn: () => fetchStatistics(userId),
    enabled: !!userId, 
  });

  if (!userId) return <div>Select a user to view statistics</div>;

  if (isLoading) return <div>Loading...</div>;
  if (isError) return <div>Error: {error.message}</div>;

  return (
    <div>
      <h2>Statistics</h2>
      {data ? (
        <ul>
          {Object.entries(data).map(([key, value]) => (
            <li key={key}>
              <strong>{key}:</strong> {value}
            </li>
          ))}
        </ul>
      ) : (
        <div>No data available</div>
      )}
    </div>
  );
};

export default Statistics;
