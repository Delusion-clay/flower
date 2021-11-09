package test;

import bean.Favorite;
import dao.FavoriteDao;
import dao.impl.FavoriteDaoImpl;

public class FavoriteDaoTest {
    public static void main(String[] args) {
        FavoriteDaoImpl favoriteDao = new FavoriteDaoImpl();
        Favorite favorite = new Favorite(8, "img_path", "百合花", "69.0");
        favoriteDao.addFavorite(favorite);
    }
}
