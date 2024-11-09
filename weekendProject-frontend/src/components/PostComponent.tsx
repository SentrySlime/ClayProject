import axios from "axios";
import { useState } from "react";

const user = {
    name: "John",
    gender: "Male",
    info: "I fucking hate you, and Want to hurt myself, this is also hardcoded"
  };

const PostComponent = () => {
  const [data, setData] = useState();
  const [response, setResponse] = useState(null);

  const postFunc = () => {
    axios.post("http://localhost:8080/api",  user)
    .then((res) => {
        setResponse(res.data);
    }).catch((error) => {
        console.error("Error posting data", error);
    });


  };

  const UpdateValue = (e) => {
    setData(e.target.value);
  };

  return (
    <div>
      <form typeof="submit"></form>
      <input onChange={UpdateValue} value={data} />
      <button onClick={postFunc}>Post</button>
      <div> This is the response {response}</div>
    </div>
  );
};

export default PostComponent;
