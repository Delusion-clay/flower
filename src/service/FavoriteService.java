package service;

import bean.Favorite;

import java.util.List;

public interface FavoriteService {
    public List<Favorite> findAll(int id);
    public boolean queryFavoriteItem(int id,String img_path);
    public void addFavorite(Favorite favorite);
    public int deleteFavorite(String img_path);
}
