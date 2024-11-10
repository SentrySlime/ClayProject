import axios from "axios";
import { useState, ChangeEvent } from "react";
import { useQueryClient } from "@tanstack/react-query";
import "./Styles/PostComponentStyle.css";

interface UserData {
  name: string;
  gender: string;
  info: string;
}

const PostComponent: React.FC = () => {
  const queryClient = useQueryClient();
  const [user, setUser] = useState<UserData>({
    name: "",
    gender: "",
    info: "",
  });

  const handleChange = (e: ChangeEvent<HTMLInputElement>) => {
    const { name, value } = e.target;
    setUser((prevUser) => ({
      ...prevUser,
      [name]: value,
    }));
  };

  const postFunc = () => {
    axios
      .post("http://localhost:8080/api", user)
      .then(() => {
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
        <form>
          <div>
            <label>
              Name:
              <input name="name" value={user.name} onChange={handleChange} />
            </label>
          </div>
          <div>
            <label>
              Gender:
              <input
                name="gender"
                value={user.gender}
                onChange={handleChange}
              />
            </label>
          </div>
          <div>
            <label>
              Info:
              <input name="info" value={user.info} onChange={handleChange} />
            </label>
          </div>
          <button className="viewStats" type="button" onClick={postFunc}>
            Post
          </button>
        </form>
      </div>
    </>
  );
};

export default PostComponent;
