package com.example.parcelabel;

import android.os.Parcel;
import android.os.Parcelable;

//public class StudentData implements Serializable
public class StudentData implements Parcelable {

    private static final long serialVersionUID = -8811375648488119429L;
    private String Name;
    private int Id;
    private Score score;

    StudentData(String name,int id, Score score) {
        this.Name = name;
        this.Id = id;
        this.score = score;
    }

    protected StudentData(Parcel in) {
        Name = in.readString();
        Id = in.readInt();
        score = in.readParcelable(Score.class.getClassLoader());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(Name);
        dest.writeInt(Id);
        dest.writeParcelable(score,flags);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<StudentData> CREATOR = new Creator<StudentData>() {
        @Override
        public StudentData createFromParcel(Parcel in) {
            return new StudentData(in);
        }

        @Override
        public StudentData[] newArray(int size) {
            return new StudentData[size];
        }
    };

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }

}

//class Score implements Serializable
class Score implements Parcelable {
    private static final long serialVersionUID = 7052106607459616826L;
    private int English;
    private int Chinses;
    private int Math;

    Score(int english,int chinses,int math) {
        this.English = english;
        this.Chinses = chinses;
        this.Math = math;
    }

    protected Score(Parcel in) {
        English = in.readInt();
        Chinses = in.readInt();
        Math = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(English);
        dest.writeInt(Chinses);
        dest.writeInt(Math);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Score> CREATOR = new Creator<Score>() {
        @Override
        public Score createFromParcel(Parcel in) {
            return new Score(in);
        }

        @Override
        public Score[] newArray(int size) {
            return new Score[size];
        }
    };

    public int getEnglish() {
        return English;
    }

    public void setEnglish(int english) {
        English = english;
    }

    public int getChinses() {
        return Chinses;
    }

    public void setChinses(int chinses) {
        Chinses = chinses;
    }

    public int getMath() {
        return Math;
    }

    public void setMath(int math) {
        Math = math;
    }
}
