import TopScetion from "../TopSection"
import Footer from "../Footer"
import ClassiScuola from "./ClassiScuola"

const ClassiScuolaSegr = ({ school }) => {
    return(
        <>
            <TopScetion text={school.nome} />
            <ClassiScuola schoolId={school.id} />
            <Footer />
        </>
    )
}

export default ClassiScuolaSegr