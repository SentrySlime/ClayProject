import axios from "axios";
import { useState } from "react";



const PostComponent = () => {
  const [data, setData] = useState();


  const postFunc = () => {
    axios.post("http://localhost:8080/api", { data });
  };

  const UpdateValue = (e) => {
    setData(e.target.value);
  };

  return (
    <div>
      <input onChange={UpdateValue} value={data} />
      <button onClick={postFunc}>Post</button>
    </div>
  );
};

export default PostComponent;
