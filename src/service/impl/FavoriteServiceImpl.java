package service.impl;

import bean.Favorite;
import dao.FavoriteDao;
import dao.impl.FavoriteDaoImpl;
import service.FavoriteService;

import java.util.List;


public class FavoriteServiceImpl implements FavoriteService {
    FavoriteDao favoriteDao = new FavoriteDaoImpl();

    @Override
    public List<Favorite> findAll(int id) {
        return favoriteDao.findAll(id);
    }

    @Override
    public boolean queryFavoriteItem(int id,String img_path) {
        return favoriteDao.queryFavoriteItem(id,img_path);
    }

    @Override
    public void addFavorite(Favorite favorite) {
        favoriteDao.addFavorite(favorite);
    }

    @Override
    public int deleteFavorite(String img_path) {
        return favoriteDao.delete(img_path);
    }
}
