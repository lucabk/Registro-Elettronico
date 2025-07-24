import TopScetion from "../TopSection"
import Footer from "../Footer"
import ClassiScuola from "./ClassiScuola"

const ClassiScuolaSegr = ({ schoolId }) => {
    return(
        <>
            <TopScetion text={"Home Page della scuola"} />
            <ClassiScuola schoolId={schoolId} />
            <Footer />
        </>
    )
}

export default ClassiScuolaSegr