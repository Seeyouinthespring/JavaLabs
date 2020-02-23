package ru.liverfluke.dao;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CompositionDAO {
    JdbcTemplate temp;

    public void setTemp(JdbcTemplate temp) {
        this.temp = temp;
    }

    public List<Composition> getAllCompositions(){
        return temp.query("select * from composition", new RowMapper<Composition>() {
            public Composition mapRow(ResultSet resultSet, int i) throws SQLException {
                Composition comp= new Composition();
                comp.setCompositionID(resultSet.getInt(1));
                comp.setTitle(resultSet.getString(2));
                comp.setLikes(resultSet.getInt(3));
                comp.setDislikes(resultSet.getInt(4));
                comp.setText(resultSet.getString(5));
                comp.setAuthorID(resultSet.getInt(6));
                comp.setGenreID(resultSet.getInt(7));
                comp.setTypeID(resultSet.getInt(8));
                comp.setStatus(resultSet.getString(9));
                return comp;
            }
        });
    }

    public Composition getCompositionsById(int id){
        String sql="Select * from composition where compositionID=?";
        return temp.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<Composition>(Composition.class));
    }

    public int update(Composition comp){
        String sql = "update composition set title='"+comp.getTitle()+"', likes="+comp.getLikes()+", dislikes="+comp.getDislikes()+", text='"+comp.getText()+"', " +
                "authorID="+comp.getAuthorID()+", genreID="+comp.getGenreID()+",typeID="+comp.getTypeID()+", status='В черновике' where compositionID="+comp.getCompositionID()+"";
        return temp.update(sql);
    }

    public int delete(int id){
        String sql="delete from composition where compositionID = "+id+"";
        return temp.update(sql);
    }

    public int insert(Composition comp) {
        String sql ="INSERT INTO composition ( title, likes, dislikes, text, authorID, genreID, typeID, status) VALUES " +
                "(' "+comp.getTitle()+"', 0, 0, '"+comp.getText()+"', "+comp.getAuthorID()+", "+comp.getGenreID()+", "+comp.getTypeID()+", 'В черновике')";
        return temp.update(sql);
    }


}
