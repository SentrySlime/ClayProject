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
  const [error, setError] = useState<string | null>(null);
  const [loading, setLoading] = useState<boolean>(false);
  const [success, setSuccess] = useState<boolean>(false);

  const handleChange = (e: ChangeEvent<HTMLInputElement>) => {
    const { name, value } = e.target;
    setUser((prevUser) => ({
      ...prevUser,
      [name]: value,
    }));
    setError(null);
  };

  const postFunc = () => {
    if (!user.name || !user.gender || !user.info) {
      setError("All fields are required.");
      return;
    }

    setLoading(true);
    setError(null);
    setSuccess(false);

    axios
      .post("http://localhost:8080/api", user)
      .then(() => {
        queryClient.invalidateQueries(["galleryData"]);
        setSuccess(true);
        setUser({ name: "", gender: "", info: "" });
      })
      .catch((error) => {
        if (error.response) {
          setError(`Server error: ${error.response.data.message || "Unknown error"}`);
        } else if (error.request) {
          setError("Network error: Please check your connection.");
        } else {
          setError(`Error: ${error.message}`);
        }
      })
      .finally(() => {
        setLoading(false);
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
              <input name="gender" value={user.gender} onChange={handleChange} />
            </label>
          </div>
          <div>
            <label>
              Info:
              <input name="info" value={user.info} onChange={handleChange} />
            </label>
          </div>
          {error && <p className="error">{error}</p>}
          {success && <p className="success">Form submitted successfully!</p>}
          <button
            className="viewStats"
            type="button"
            onClick={postFunc}
            disabled={loading}
          >
            {loading ? "Submitting..." : "Post"}
          </button>
        </form>
      </div>
    </>
  );
};

export default PostComponent;
