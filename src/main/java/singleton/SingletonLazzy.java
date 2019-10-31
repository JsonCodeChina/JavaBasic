package singleton;

public class SingletonLazzy {

    private static SingletonLazzy lazzy;

    private SingletonLazzy(){

    }

    public synchronized static SingletonLazzy getInstance(){
        if(lazzy == null){
            lazzy = new SingletonLazzy();
        }
        return lazzy;
    }

}
