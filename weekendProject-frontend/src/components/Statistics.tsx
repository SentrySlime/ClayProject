import { useQuery } from "@tanstack/react-query";
import axios from "axios";
import {
  BarChart,
  Bar,
  XAxis,
  YAxis,
  Tooltip,
  Legend,
  CartesianGrid,
} from "recharts"; 

const fetchStatistics = async (userId) => {
  const response = await axios.get(`http://localhost:8080/api/data/${userId}`);
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

  const barData = Object.entries(data).map(([key, value]) => ({
    name: key,
    value: typeof value === "number" ? value : 0, 
  }));

  return (
    <div>
      <h2>Statistics</h2>
      {data ? (
        <BarChart
          width={500}
          height={300}
          data={barData}
          margin={{ top: 20, right: 30, left: 20, bottom: 5 }}
        >
          <CartesianGrid strokeDasharray="3 3" />
          <XAxis dataKey="name" />
          <YAxis />
          <Tooltip />
          <Legend />
          <Bar dataKey="value" fill="#8884d8" />
        </BarChart>
      ) : (
        <div>No data available</div>
      )}
    </div>
  );
};

export default Statistics;
