import axios from "axios";
import { useState } from "react";
import { useQueryClient } from "@tanstack/react-query";
import './Styles/PostComponentStyle.css';

const PostComponent = () => {
  const queryClient = useQueryClient();

  

  const [user, setUser] = useState({
    name: "",
    gender: "",
    info: "",
  });

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
        queryClient.invalidateQueries(["galleryData"]);
      })
      .catch((error) => {
        console.error("Error posting data", error);
      });
  };

  return (
    <>
      <h1>Submit Form</h1>
      <div className="submitForm">
        <form typeof="submit"></form>

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
    </>
  );
};

export default PostComponent;
