import { useQuery } from "@tanstack/react-query";
import axios from "axios";
import User from "./User";

const fetchGalleryData = async () => {
  const response = await axios.get("http://localhost:8080/api");
  console.log("This is our response data: " + response.data);
  return response.data;
};

const Gallery = () => {
  // Unique query key for Gallery component
  const { data, isLoading, isError, error } = useQuery({
    queryKey: ["galleryData"],
    queryFn: fetchGalleryData,
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
