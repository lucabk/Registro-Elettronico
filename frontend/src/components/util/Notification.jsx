const Notification = ({ msg=null, type }) => {

  return(
        <>
            { msg &&
                (
                    type === "success" ?
                    <div className="alert alert-success" role="alert">
                        { msg }
                    </div> :
                    <div className="alert alert-danger" role="alert">
                        { msg }
                    </div>
                )
            }
        </>
    )
}


export default Notification