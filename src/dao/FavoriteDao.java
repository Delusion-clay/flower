package dao;

import bean.Favorite;

import java.util.List;


public interface FavoriteDao {
    public boolean queryFavoriteItem(int id,String img_path);
    public void addFavorite(Favorite favorite);
    public List<Favorite> findAll(int id);
    public int delete(String img_path);
}
