import { useQuery } from "@tanstack/react-query";
import axios from "axios";

const fetchFunc = async () => {
  const response = await axios.get(
    "http://localhost:8080/api"
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
      
    </div>
  );
};

export default GetComponent;
