import { useQuery } from "@tanstack/react-query";
import axios from "axios";

const fetchFunc = async () => {
  const response = await axios.get(
    "http://localhost:8080/api/42dba3c2-3858-4da2-a442-c2860f050f77"
  );
  return response.data;
};

const GetComponent = () => {
  const { data, isLoading, isError, error } = useQuery({
    queryKey: ["myData"],
    queryFn: fetchFunc,
  });

  if (isLoading) return <div>Is Loading...</div>;
  if (isError) return <div>Error {error.message}</div>;

  return (
    <div>
      <button onClick={fetchFunc}>Get</button>
      <p>{data.id}</p>
      <p>{data.name}</p>
      <p>{data.gender}</p>
    </div>
  );
};

export default GetComponent;
