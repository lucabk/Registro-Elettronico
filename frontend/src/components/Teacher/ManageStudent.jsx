import Footer from "../Footer"
import TopScetion from "../TopSection"

const ManageStudent = ({ studentId, incarichi, classId }) => {

    console.log("ManageStudent studentId: ", studentId)
    console.log("ManageStudent incarichi: ", incarichi)
    console.log("ManageStudent classId: ", classId)

    return(
        <>
            <TopScetion text={"Gestisci studente"} />

            <Footer />
        </>
    )
}

export default ManageStudent