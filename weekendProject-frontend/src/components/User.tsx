import './Styles/UserStyle.css';

const User = ({ user, onSelectUser }) => {
  const handleSelectUser = () => {
    onSelectUser(user.id);
  };

  if (!user) return <div>User data is unavailable</div>;

  return (
    <div className="userContainer">
      <div className="userInfo">
        This is user: {user.name} : {user.gender}
      </div>
      <button onClick={handleSelectUser} className="viewButton">View Statistics</button>
    </div>
  );
};

export default User;
