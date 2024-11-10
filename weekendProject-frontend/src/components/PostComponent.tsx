import axios from "axios";
import { useState } from "react";
import { useQueryClient } from "@tanstack/react-query"; // Import useQueryClient

const PostComponent = () => {
  const queryClient = useQueryClient(); // Initialize query client

  const styles = {
    border: "1px solid rgba(0, 0, 0, 0.5)",
  };

  const [user, setUser] = useState({
    name: "",
    gender: "",
    info: "",
  });

  const [response, setResponse] = useState(null);

  const handleChange = (e) => {
    const { name, value } = e.target;
    setUser((prevUser) => ({
      ...prevUser,
      [name]: value,
    }));
  };

  const postFunc = () => {
    axios
      .post("http://localhost:8080/api", user)
      .then((res) => {
        setResponse(res.data);
        queryClient.invalidateQueries(["myData"]); // Invalidate query after successful post
      })
      .catch((error) => {
        console.error("Error posting data", error);
      });
  };

  return (
    <div>
      <h1>Submit Form</h1>
      <div style={styles}>
        <div>
          <label>
            Name:
            <input name="name" value={user.name} onChange={handleChange} />
          </label>
        </div>

        <div>
          <label>
            Gender:
            <input name="gender" value={user.gender} onChange={handleChange} />
          </label>
        </div>

        <div>
          <label>
            Info:
            <input name="info" value={user.info} onChange={handleChange} />
          </label>
        </div>

        <button onClick={postFunc}>Post</button>
      </div>
    </div>
  );
};

export default PostComponent;
