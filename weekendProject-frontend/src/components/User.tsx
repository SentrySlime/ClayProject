const User = ({ user, onSelectUser }) => {
    const handleSelectUser = () => {
      onSelectUser(user.id);
    };
  
    if (!user) return <div>User data is unavailable</div>;
  
    return (
      <div style={{ display: "flex", alignItems: "center" }}>
        <div>
          This is user: {user.name} : {user.gender}
        </div>
        <button onClick={handleSelectUser}>View Statistics</button>
      </div>
    );
  };
  
  export default User;
  