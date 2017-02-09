
package creativechaos.samplerxandroid.models;


import java.util.ArrayList;

public class UserRepository {

    private ArrayList<RepositoryDetail> repositoryCollection;

    public UserRepository(ArrayList<RepositoryDetail> repositoryCollection) {
        this.repositoryCollection = repositoryCollection;
    }


    //region Getter Setter Methods

    public ArrayList<RepositoryDetail> getRepositoryCollection() {
        return repositoryCollection;
    }

    public void setRepositoryCollection(ArrayList<RepositoryDetail> repositoryCollection) {
        this.repositoryCollection = repositoryCollection;
    }

    //endregion
}
