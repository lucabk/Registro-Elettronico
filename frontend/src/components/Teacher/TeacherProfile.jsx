import Footer from "../Footer"
import TopScetion from "../TopSection"

const TeacherProfile = ({ teacher }) => {
    return(
        <>
            <TopScetion text={"Profilo docente"} />
                {teacher?.nome} {teacher?.cognome}
            <Footer />
        </>
    )
}

export default TeacherProfile