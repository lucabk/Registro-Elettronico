const notification = (setNotification, msg, type) => {
    setNotification({ msg, type })
    setTimeout(()=>{
        setNotification({ msg:null, type:null })
    }, 5000)
}

export default notification;