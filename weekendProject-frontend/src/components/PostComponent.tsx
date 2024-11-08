import axios from "axios";
import { useState } from "react";

const user = {
    name: "John",
    gender: "Male",
    info: "I fucking hate you, and Want to cut myself, this is also hardcoded"
  };

const PostComponent = () => {
  const [data, setData] = useState();

  const postFunc = () => {
    axios.post("http://localhost:8080/api",  user);
  };

  const UpdateValue = (e) => {
    setData(e.target.value);
  };

  return (
    <div>
      <form typeof="submit"></form>
      <input onChange={UpdateValue} value={data} />
      <button onClick={postFunc}>Post</button>
    </div>
  );
};

export default PostComponent;
