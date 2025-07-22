const SchoolHomePage = ({ school }) => {
    return(
        <>
            <h1>School Home Page</h1>
            <h2>{school && school.nome}</h2>
        </>
    )
}

export default SchoolHomePage