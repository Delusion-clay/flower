package dao.impl;
import bean.Favorite;
import dao.FavoriteDao;

import java.util.List;


public class FavoriteDaoImpl extends BaseDao implements FavoriteDao {
    @Override
    public boolean queryFavoriteItem(int id,String img_path) {
        String sql = "select * from flower.favorite where id = ? and img_path=?";
        Favorite item = queryForOne(Favorite.class, sql,id, img_path);
        if (item==null){
            return false;
        }
        return true;
    }

    @Override
    public void addFavorite(Favorite favorite) {
        String sql = "insert into flower.favorite(`id`,`img_path`,`type`,`price`) values(?,?,?,?)";
        update(sql, favorite.getId(), favorite.getImg_path(), favorite.getType(), favorite.getPrice());
    }

    @Override
    public List<Favorite> findAll(int id) {
        String sql = "select * from flower.favorite where id=?";
        return queryForList(Favorite.class,sql,id);
    }

    @Override
    public int delete(String img_path) {
        String sql = "delete from flower.favorite where img_path=?";
        return update(sql,img_path);
    }
}
