import { useQuery } from "@tanstack/react-query";
import axios from "axios";

const fetchFunc = async () => {
  const response = await axios.get(
    "http://localhost:8080/api/data/969f4b7c-5758-42b7-bdae-9272891cb8b0"
  );
  console.log(response.data);
  return response.data;
};

const Statistics = () => {
  const { data, isLoading, isError, error } = useQuery({
    queryKey: ["myData"],
    queryFn: fetchFunc,
  });

  if (isLoading) return <div>Is Loading...</div>;
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
