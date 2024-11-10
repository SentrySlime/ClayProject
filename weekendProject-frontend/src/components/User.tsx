const User = () => {
  const userInfo = {
    id: "id",
    name: "John",
    gender: "Male",
    info: "I am going to hurt myself tonight. I plan to cut myself because I can’t handle this anymore. I want to take my own life; I don’t see a reason to live.",
  };

  return (
    <div>
      <div>{userInfo.name} : {userInfo.gender} </div>
    </div>
  );
};

export default User;
