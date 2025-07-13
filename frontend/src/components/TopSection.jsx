const TopScetion = ({ text, bg = "grey" }) => {
    let content
    let h1 = (
        <h1 className="text-center fs-1 fw-bold">{text}</h1>
    )
    
    switch (bg) {
        
        case "green":
            content = (
                <div className="container-fluid p-5 bg-success ">
                    {h1}
                </div>
            )
            break

        default:
            content = (
                <div className="container-fluid p-5 bg-secondary ">
                    {h1}
                </div>
            )
    }
    
    return content
}

export default TopScetion