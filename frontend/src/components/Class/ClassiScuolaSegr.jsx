import TopScetion from "../TopSection"
import Footer from "../Footer"
import ClassiScuola from "./ClassiScuola"

const ClassiScuolaSegr = ({ schoolId }) => {
    return(
        <>
            <TopScetion text={"Home Page della scuola"} bg={"segr"}/>
            <ClassiScuola schoolId={schoolId} />
            <Footer bg={"segr"}/>
        </>
    )
}

export default ClassiScuolaSegr