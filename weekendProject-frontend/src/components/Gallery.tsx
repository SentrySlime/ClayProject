import { useQuery } from "@tanstack/react-query";
import axios from "axios";
import User from "./User";

const fetchGalleryData = async () => {
  const response = await axios.get("http://localhost:8080/api");
  return response.data;
};

const Gallery = ({ onSelectUser }) => {
  const { data, isLoading, isError, error } = useQuery({
    queryKey: ["galleryData"],
    queryFn: fetchGalleryData,
  });

  if (isLoading) return <div>Loading...</div>;
  if (isError) return <div>Error: {error.message}</div>;

  return (
    <div>
      <h2>User Gallery</h2>
      {data && data.length > 0 ? (
        data.map((user) => (
          <User key={user.id} user={user} onSelectUser={onSelectUser} />
        ))
      ) : (
        <div>No user data available</div>
      )}
    </div>
  );
};

export default Gallery;
