const User = ({ user }) => {
    if (!user) {
      return <div>User data is unavailable</div>;
    }
  
    return (
      <div style={{ display: 'flex', alignItems: 'center' }}>
        <div>
          This is user: {user.name} : {user.gender}
        </div>
        <button  >Delete</button>
      </div>
    );
  };
  
  export default User;
  