import "./Styles/UserStyle.css";

interface UserProps {
  user: { id: string; name: string; gender: string };
  onSelectUser: (id: string) => void;
}

const User: React.FC<UserProps> = ({ user, onSelectUser }) => {
  const handleSelectUser = () => {
    onSelectUser(user.id);
  };

  if (!user) return <div>User data is unavailable</div>;

  return (
    <div className="userContainer">
      <div className="userInfo">
        {user.name} : {user.gender}
      </div>
      <button onClick={handleSelectUser} className="viewButton">
        View Statistics
      </button>
    </div>
  );
};

export default User;
