import { useQuery } from "@tanstack/react-query";
import axios from "axios";
import User from "./User";

const fetchFunc = async () => {
  const response = await axios.get("http://localhost:8080/api");
  return response.data;
};

const Gallery = () => {
  const { data, isLoading, isError, error } = useQuery({
    queryKey: ["myData"],
    queryFn: fetchFunc,
  });

  if (isLoading) return <div>Is Loading...</div>;
  if (isError) return <div>Error: {error.message}</div>;

  return (
    <div>
      {data && data.length > 0 ? (
        data.map((user, index) => <User key={index} user={user} />)
      ) : (
        <div>No user data available</div>
      )}
    </div>
  );
};

export default Gallery;
