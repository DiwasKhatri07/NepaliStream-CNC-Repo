package com.OneTouchTV;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: OneTouchTVParser.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/OneTouchTV/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001:\u0003\u001a\u001b\u001cB=\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003¢\u0006\u0004\b\t\u0010\nJ\u0011\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003HÆ\u0003J?\u0010\u0012\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00032\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0016\u001a\u00020\u0017HÖ\u0081\u0004J\n\u0010\u0018\u001a\u00020\u0019HÖ\u0081\u0004R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0019\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f¨\u0006\u001d"}, d2 = {"Lcom/OneTouchTV/OneTouchTVParser;", "", "day", "", "Lcom/OneTouchTV/OneTouchTVParser$Day;", "week", "Lcom/OneTouchTV/OneTouchTVParser$Week;", "month", "Lcom/OneTouchTV/OneTouchTVParser$Month;", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getDay", "()Ljava/util/List;", "getWeek", "getMonth", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Day", "Week", "Month", "OneTouchTV"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class OneTouchTVParser {

    @Nullable
    private final List<Day> day;

    @Nullable
    private final List<Month> month;

    @Nullable
    private final List<Week> week;

    public OneTouchTVParser() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OneTouchTVParser copy$default(OneTouchTVParser oneTouchTVParser, List list, List list2, List list3, int i, Object obj) {
        if ((i & 1) != 0) {
            list = oneTouchTVParser.day;
        }
        if ((i & 2) != 0) {
            list2 = oneTouchTVParser.week;
        }
        if ((i & 4) != 0) {
            list3 = oneTouchTVParser.month;
        }
        return oneTouchTVParser.copy(list, list2, list3);
    }

    @Nullable
    public final List<Day> component1() {
        return this.day;
    }

    @Nullable
    public final List<Week> component2() {
        return this.week;
    }

    @Nullable
    public final List<Month> component3() {
        return this.month;
    }

    @NotNull
    public final OneTouchTVParser copy(@Nullable List<Day> day, @Nullable List<Week> week, @Nullable List<Month> month) {
        return new OneTouchTVParser(day, week, month);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OneTouchTVParser)) {
            return false;
        }
        OneTouchTVParser oneTouchTVParser = (OneTouchTVParser) other;
        return Intrinsics.areEqual(this.day, oneTouchTVParser.day) && Intrinsics.areEqual(this.week, oneTouchTVParser.week) && Intrinsics.areEqual(this.month, oneTouchTVParser.month);
    }

    public int hashCode() {
        return ((((this.day == null ? 0 : this.day.hashCode()) * 31) + (this.week == null ? 0 : this.week.hashCode())) * 31) + (this.month != null ? this.month.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "OneTouchTVParser(day=" + this.day + ", week=" + this.week + ", month=" + this.month + ')';
    }

    public OneTouchTVParser(@Nullable List<Day> list, @Nullable List<Week> list2, @Nullable List<Month> list3) {
        this.day = list;
        this.week = list2;
        this.month = list3;
    }

    public /* synthetic */ OneTouchTVParser(List list, List list2, List list3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? CollectionsKt.emptyList() : list, (i & 2) != 0 ? CollectionsKt.emptyList() : list2, (i & 4) != 0 ? CollectionsKt.emptyList() : list3);
    }

    @Nullable
    public final List<Day> getDay() {
        return this.day;
    }

    @Nullable
    public final List<Week> getWeek() {
        return this.week;
    }

    @Nullable
    public final List<Month> getMonth() {
        return this.month;
    }

    /* JADX INFO: compiled from: OneTouchTVParser.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b \b\u0086\b\u0018\u00002\u00020\u0001B\u0087\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u000bHÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u000fHÆ\u0003J\u0089\u0001\u0010*\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u000fHÆ\u0001J\u0014\u0010+\u001a\u00020\u000f2\b\u0010,\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010-\u001a\u00020\u000bHÖ\u0081\u0004J\n\u0010.\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0013R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0013R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0013R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0013R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u001e¨\u0006/"}, d2 = {"Lcom/OneTouchTV/OneTouchTVParser$Day;", "", "_id", "", "id", "title", "image", "country", "type", "year", "popularity", "", "status", "releaseDate", "isSub", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Z)V", "get_id", "()Ljava/lang/String;", "getId", "getTitle", "getImage", "getCountry", "getType", "getYear", "getPopularity", "()I", "getStatus", "getReleaseDate", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "equals", "other", "hashCode", "toString", "OneTouchTV"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class Day {

        @Nullable
        private final String _id;

        @Nullable
        private final String country;

        @Nullable
        private final String id;

        @Nullable
        private final String image;
        private final boolean isSub;
        private final int popularity;

        @Nullable
        private final String releaseDate;

        @Nullable
        private final String status;

        @Nullable
        private final String title;

        @Nullable
        private final String type;

        @Nullable
        private final String year;

        public Day() {
            this(null, null, null, null, null, null, null, 0, null, null, false, 2047, null);
        }

        public static /* synthetic */ Day copy$default(Day day, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, String str8, String str9, boolean z, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = day._id;
            }
            if ((i2 & 2) != 0) {
                str2 = day.id;
            }
            if ((i2 & 4) != 0) {
                str3 = day.title;
            }
            if ((i2 & 8) != 0) {
                str4 = day.image;
            }
            if ((i2 & 16) != 0) {
                str5 = day.country;
            }
            if ((i2 & 32) != 0) {
                str6 = day.type;
            }
            if ((i2 & 64) != 0) {
                str7 = day.year;
            }
            if ((i2 & 128) != 0) {
                i = day.popularity;
            }
            if ((i2 & 256) != 0) {
                str8 = day.status;
            }
            if ((i2 & 512) != 0) {
                str9 = day.releaseDate;
            }
            if ((i2 & 1024) != 0) {
                z = day.isSub;
            }
            String str10 = str9;
            boolean z2 = z;
            int i3 = i;
            String str11 = str8;
            String str12 = str6;
            String str13 = str7;
            String str14 = str5;
            String str15 = str3;
            return day.copy(str, str2, str15, str4, str14, str12, str13, i3, str11, str10, z2);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String get_id() {
            return this._id;
        }

        @Nullable
        /* JADX INFO: renamed from: component10, reason: from getter */
        public final String getReleaseDate() {
            return this.releaseDate;
        }

        /* JADX INFO: renamed from: component11, reason: from getter */
        public final boolean getIsSub() {
            return this.isSub;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getId() {
            return this.id;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        @Nullable
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getImage() {
            return this.image;
        }

        @Nullable
        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getCountry() {
            return this.country;
        }

        @Nullable
        /* JADX INFO: renamed from: component6, reason: from getter */
        public final String getType() {
            return this.type;
        }

        @Nullable
        /* JADX INFO: renamed from: component7, reason: from getter */
        public final String getYear() {
            return this.year;
        }

        /* JADX INFO: renamed from: component8, reason: from getter */
        public final int getPopularity() {
            return this.popularity;
        }

        @Nullable
        /* JADX INFO: renamed from: component9, reason: from getter */
        public final String getStatus() {
            return this.status;
        }

        @NotNull
        public final Day copy(@Nullable String _id, @Nullable String id, @Nullable String title, @Nullable String image, @Nullable String country, @Nullable String type, @Nullable String year, int popularity, @Nullable String status, @Nullable String releaseDate, boolean isSub) {
            return new Day(_id, id, title, image, country, type, year, popularity, status, releaseDate, isSub);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Day)) {
                return false;
            }
            Day day = (Day) other;
            return Intrinsics.areEqual(this._id, day._id) && Intrinsics.areEqual(this.id, day.id) && Intrinsics.areEqual(this.title, day.title) && Intrinsics.areEqual(this.image, day.image) && Intrinsics.areEqual(this.country, day.country) && Intrinsics.areEqual(this.type, day.type) && Intrinsics.areEqual(this.year, day.year) && this.popularity == day.popularity && Intrinsics.areEqual(this.status, day.status) && Intrinsics.areEqual(this.releaseDate, day.releaseDate) && this.isSub == day.isSub;
        }

        public int hashCode() {
            return ((((((((((((((((((((this._id == null ? 0 : this._id.hashCode()) * 31) + (this.id == null ? 0 : this.id.hashCode())) * 31) + (this.title == null ? 0 : this.title.hashCode())) * 31) + (this.image == null ? 0 : this.image.hashCode())) * 31) + (this.country == null ? 0 : this.country.hashCode())) * 31) + (this.type == null ? 0 : this.type.hashCode())) * 31) + (this.year == null ? 0 : this.year.hashCode())) * 31) + this.popularity) * 31) + (this.status == null ? 0 : this.status.hashCode())) * 31) + (this.releaseDate != null ? this.releaseDate.hashCode() : 0)) * 31) + OneTouchTVParser$Day$$ExternalSyntheticBackport0.m2m(this.isSub);
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Day(_id=").append(this._id).append(", id=").append(this.id).append(", title=").append(this.title).append(", image=").append(this.image).append(", country=").append(this.country).append(", type=").append(this.type).append(", year=").append(this.year).append(", popularity=").append(this.popularity).append(", status=").append(this.status).append(", releaseDate=").append(this.releaseDate).append(", isSub=").append(this.isSub).append(')');
            return sb.toString();
        }

        public Day(@Nullable String _id, @Nullable String id, @Nullable String title, @Nullable String image, @Nullable String country, @Nullable String type, @Nullable String year, int popularity, @Nullable String status, @Nullable String releaseDate, boolean isSub) {
            this._id = _id;
            this.id = id;
            this.title = title;
            this.image = image;
            this.country = country;
            this.type = type;
            this.year = year;
            this.popularity = popularity;
            this.status = status;
            this.releaseDate = releaseDate;
            this.isSub = isSub;
        }

        public /* synthetic */ Day(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, String str8, String str9, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : str2, (i2 & 4) != 0 ? null : str3, (i2 & 8) != 0 ? null : str4, (i2 & 16) != 0 ? null : str5, (i2 & 32) != 0 ? null : str6, (i2 & 64) != 0 ? null : str7, (i2 & 128) != 0 ? 0 : i, (i2 & 256) != 0 ? null : str8, (i2 & 512) != 0 ? null : str9, (i2 & 1024) != 0 ? false : z);
        }

        @Nullable
        public final String get_id() {
            return this._id;
        }

        @Nullable
        public final String getId() {
            return this.id;
        }

        @Nullable
        public final String getTitle() {
            return this.title;
        }

        @Nullable
        public final String getImage() {
            return this.image;
        }

        @Nullable
        public final String getCountry() {
            return this.country;
        }

        @Nullable
        public final String getType() {
            return this.type;
        }

        @Nullable
        public final String getYear() {
            return this.year;
        }

        public final int getPopularity() {
            return this.popularity;
        }

        @Nullable
        public final String getStatus() {
            return this.status;
        }

        @Nullable
        public final String getReleaseDate() {
            return this.releaseDate;
        }

        public final boolean isSub() {
            return this.isSub;
        }
    }

    /* JADX INFO: compiled from: OneTouchTVParser.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b \b\u0086\b\u0018\u00002\u00020\u0001B\u0087\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u000bHÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u000fHÆ\u0003J\u0089\u0001\u0010*\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u000fHÆ\u0001J\u0014\u0010+\u001a\u00020\u000f2\b\u0010,\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010-\u001a\u00020\u000bHÖ\u0081\u0004J\n\u0010.\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0013R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0013R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0013R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0013R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u001e¨\u0006/"}, d2 = {"Lcom/OneTouchTV/OneTouchTVParser$Week;", "", "_id", "", "id", "title", "image", "country", "type", "year", "popularity", "", "status", "releaseDate", "isSub", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Z)V", "get_id", "()Ljava/lang/String;", "getId", "getTitle", "getImage", "getCountry", "getType", "getYear", "getPopularity", "()I", "getStatus", "getReleaseDate", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "equals", "other", "hashCode", "toString", "OneTouchTV"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class Week {

        @Nullable
        private final String _id;

        @Nullable
        private final String country;

        @Nullable
        private final String id;

        @Nullable
        private final String image;
        private final boolean isSub;
        private final int popularity;

        @Nullable
        private final String releaseDate;

        @Nullable
        private final String status;

        @Nullable
        private final String title;

        @Nullable
        private final String type;

        @Nullable
        private final String year;

        public Week() {
            this(null, null, null, null, null, null, null, 0, null, null, false, 2047, null);
        }

        public static /* synthetic */ Week copy$default(Week week, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, String str8, String str9, boolean z, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = week._id;
            }
            if ((i2 & 2) != 0) {
                str2 = week.id;
            }
            if ((i2 & 4) != 0) {
                str3 = week.title;
            }
            if ((i2 & 8) != 0) {
                str4 = week.image;
            }
            if ((i2 & 16) != 0) {
                str5 = week.country;
            }
            if ((i2 & 32) != 0) {
                str6 = week.type;
            }
            if ((i2 & 64) != 0) {
                str7 = week.year;
            }
            if ((i2 & 128) != 0) {
                i = week.popularity;
            }
            if ((i2 & 256) != 0) {
                str8 = week.status;
            }
            if ((i2 & 512) != 0) {
                str9 = week.releaseDate;
            }
            if ((i2 & 1024) != 0) {
                z = week.isSub;
            }
            String str10 = str9;
            boolean z2 = z;
            int i3 = i;
            String str11 = str8;
            String str12 = str6;
            String str13 = str7;
            String str14 = str5;
            String str15 = str3;
            return week.copy(str, str2, str15, str4, str14, str12, str13, i3, str11, str10, z2);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String get_id() {
            return this._id;
        }

        @Nullable
        /* JADX INFO: renamed from: component10, reason: from getter */
        public final String getReleaseDate() {
            return this.releaseDate;
        }

        /* JADX INFO: renamed from: component11, reason: from getter */
        public final boolean getIsSub() {
            return this.isSub;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getId() {
            return this.id;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        @Nullable
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getImage() {
            return this.image;
        }

        @Nullable
        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getCountry() {
            return this.country;
        }

        @Nullable
        /* JADX INFO: renamed from: component6, reason: from getter */
        public final String getType() {
            return this.type;
        }

        @Nullable
        /* JADX INFO: renamed from: component7, reason: from getter */
        public final String getYear() {
            return this.year;
        }

        /* JADX INFO: renamed from: component8, reason: from getter */
        public final int getPopularity() {
            return this.popularity;
        }

        @Nullable
        /* JADX INFO: renamed from: component9, reason: from getter */
        public final String getStatus() {
            return this.status;
        }

        @NotNull
        public final Week copy(@Nullable String _id, @Nullable String id, @Nullable String title, @Nullable String image, @Nullable String country, @Nullable String type, @Nullable String year, int popularity, @Nullable String status, @Nullable String releaseDate, boolean isSub) {
            return new Week(_id, id, title, image, country, type, year, popularity, status, releaseDate, isSub);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Week)) {
                return false;
            }
            Week week = (Week) other;
            return Intrinsics.areEqual(this._id, week._id) && Intrinsics.areEqual(this.id, week.id) && Intrinsics.areEqual(this.title, week.title) && Intrinsics.areEqual(this.image, week.image) && Intrinsics.areEqual(this.country, week.country) && Intrinsics.areEqual(this.type, week.type) && Intrinsics.areEqual(this.year, week.year) && this.popularity == week.popularity && Intrinsics.areEqual(this.status, week.status) && Intrinsics.areEqual(this.releaseDate, week.releaseDate) && this.isSub == week.isSub;
        }

        public int hashCode() {
            return ((((((((((((((((((((this._id == null ? 0 : this._id.hashCode()) * 31) + (this.id == null ? 0 : this.id.hashCode())) * 31) + (this.title == null ? 0 : this.title.hashCode())) * 31) + (this.image == null ? 0 : this.image.hashCode())) * 31) + (this.country == null ? 0 : this.country.hashCode())) * 31) + (this.type == null ? 0 : this.type.hashCode())) * 31) + (this.year == null ? 0 : this.year.hashCode())) * 31) + this.popularity) * 31) + (this.status == null ? 0 : this.status.hashCode())) * 31) + (this.releaseDate != null ? this.releaseDate.hashCode() : 0)) * 31) + OneTouchTVParser$Week$$ExternalSyntheticBackport0.m4m(this.isSub);
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Week(_id=").append(this._id).append(", id=").append(this.id).append(", title=").append(this.title).append(", image=").append(this.image).append(", country=").append(this.country).append(", type=").append(this.type).append(", year=").append(this.year).append(", popularity=").append(this.popularity).append(", status=").append(this.status).append(", releaseDate=").append(this.releaseDate).append(", isSub=").append(this.isSub).append(')');
            return sb.toString();
        }

        public Week(@Nullable String _id, @Nullable String id, @Nullable String title, @Nullable String image, @Nullable String country, @Nullable String type, @Nullable String year, int popularity, @Nullable String status, @Nullable String releaseDate, boolean isSub) {
            this._id = _id;
            this.id = id;
            this.title = title;
            this.image = image;
            this.country = country;
            this.type = type;
            this.year = year;
            this.popularity = popularity;
            this.status = status;
            this.releaseDate = releaseDate;
            this.isSub = isSub;
        }

        public /* synthetic */ Week(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, String str8, String str9, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : str2, (i2 & 4) != 0 ? null : str3, (i2 & 8) != 0 ? null : str4, (i2 & 16) != 0 ? null : str5, (i2 & 32) != 0 ? null : str6, (i2 & 64) != 0 ? null : str7, (i2 & 128) != 0 ? 0 : i, (i2 & 256) != 0 ? null : str8, (i2 & 512) != 0 ? null : str9, (i2 & 1024) != 0 ? false : z);
        }

        @Nullable
        public final String get_id() {
            return this._id;
        }

        @Nullable
        public final String getId() {
            return this.id;
        }

        @Nullable
        public final String getTitle() {
            return this.title;
        }

        @Nullable
        public final String getImage() {
            return this.image;
        }

        @Nullable
        public final String getCountry() {
            return this.country;
        }

        @Nullable
        public final String getType() {
            return this.type;
        }

        @Nullable
        public final String getYear() {
            return this.year;
        }

        public final int getPopularity() {
            return this.popularity;
        }

        @Nullable
        public final String getStatus() {
            return this.status;
        }

        @Nullable
        public final String getReleaseDate() {
            return this.releaseDate;
        }

        public final boolean isSub() {
            return this.isSub;
        }
    }

    /* JADX INFO: compiled from: OneTouchTVParser.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b \b\u0086\b\u0018\u00002\u00020\u0001B\u0087\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u000bHÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u000fHÆ\u0003J\u0089\u0001\u0010*\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u000fHÆ\u0001J\u0014\u0010+\u001a\u00020\u000f2\b\u0010,\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010-\u001a\u00020\u000bHÖ\u0081\u0004J\n\u0010.\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0013R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0013R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0013R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0013R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u001e¨\u0006/"}, d2 = {"Lcom/OneTouchTV/OneTouchTVParser$Month;", "", "_id", "", "id", "title", "image", "country", "type", "year", "popularity", "", "status", "releaseDate", "isSub", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Z)V", "get_id", "()Ljava/lang/String;", "getId", "getTitle", "getImage", "getCountry", "getType", "getYear", "getPopularity", "()I", "getStatus", "getReleaseDate", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "equals", "other", "hashCode", "toString", "OneTouchTV"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class Month {

        @Nullable
        private final String _id;

        @Nullable
        private final String country;

        @Nullable
        private final String id;

        @Nullable
        private final String image;
        private final boolean isSub;
        private final int popularity;

        @Nullable
        private final String releaseDate;

        @Nullable
        private final String status;

        @Nullable
        private final String title;

        @Nullable
        private final String type;

        @Nullable
        private final String year;

        public Month() {
            this(null, null, null, null, null, null, null, 0, null, null, false, 2047, null);
        }

        public static /* synthetic */ Month copy$default(Month month, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, String str8, String str9, boolean z, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = month._id;
            }
            if ((i2 & 2) != 0) {
                str2 = month.id;
            }
            if ((i2 & 4) != 0) {
                str3 = month.title;
            }
            if ((i2 & 8) != 0) {
                str4 = month.image;
            }
            if ((i2 & 16) != 0) {
                str5 = month.country;
            }
            if ((i2 & 32) != 0) {
                str6 = month.type;
            }
            if ((i2 & 64) != 0) {
                str7 = month.year;
            }
            if ((i2 & 128) != 0) {
                i = month.popularity;
            }
            if ((i2 & 256) != 0) {
                str8 = month.status;
            }
            if ((i2 & 512) != 0) {
                str9 = month.releaseDate;
            }
            if ((i2 & 1024) != 0) {
                z = month.isSub;
            }
            String str10 = str9;
            boolean z2 = z;
            int i3 = i;
            String str11 = str8;
            String str12 = str6;
            String str13 = str7;
            String str14 = str5;
            String str15 = str3;
            return month.copy(str, str2, str15, str4, str14, str12, str13, i3, str11, str10, z2);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String get_id() {
            return this._id;
        }

        @Nullable
        /* JADX INFO: renamed from: component10, reason: from getter */
        public final String getReleaseDate() {
            return this.releaseDate;
        }

        /* JADX INFO: renamed from: component11, reason: from getter */
        public final boolean getIsSub() {
            return this.isSub;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getId() {
            return this.id;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        @Nullable
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getImage() {
            return this.image;
        }

        @Nullable
        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getCountry() {
            return this.country;
        }

        @Nullable
        /* JADX INFO: renamed from: component6, reason: from getter */
        public final String getType() {
            return this.type;
        }

        @Nullable
        /* JADX INFO: renamed from: component7, reason: from getter */
        public final String getYear() {
            return this.year;
        }

        /* JADX INFO: renamed from: component8, reason: from getter */
        public final int getPopularity() {
            return this.popularity;
        }

        @Nullable
        /* JADX INFO: renamed from: component9, reason: from getter */
        public final String getStatus() {
            return this.status;
        }

        @NotNull
        public final Month copy(@Nullable String _id, @Nullable String id, @Nullable String title, @Nullable String image, @Nullable String country, @Nullable String type, @Nullable String year, int popularity, @Nullable String status, @Nullable String releaseDate, boolean isSub) {
            return new Month(_id, id, title, image, country, type, year, popularity, status, releaseDate, isSub);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Month)) {
                return false;
            }
            Month month = (Month) other;
            return Intrinsics.areEqual(this._id, month._id) && Intrinsics.areEqual(this.id, month.id) && Intrinsics.areEqual(this.title, month.title) && Intrinsics.areEqual(this.image, month.image) && Intrinsics.areEqual(this.country, month.country) && Intrinsics.areEqual(this.type, month.type) && Intrinsics.areEqual(this.year, month.year) && this.popularity == month.popularity && Intrinsics.areEqual(this.status, month.status) && Intrinsics.areEqual(this.releaseDate, month.releaseDate) && this.isSub == month.isSub;
        }

        public int hashCode() {
            return ((((((((((((((((((((this._id == null ? 0 : this._id.hashCode()) * 31) + (this.id == null ? 0 : this.id.hashCode())) * 31) + (this.title == null ? 0 : this.title.hashCode())) * 31) + (this.image == null ? 0 : this.image.hashCode())) * 31) + (this.country == null ? 0 : this.country.hashCode())) * 31) + (this.type == null ? 0 : this.type.hashCode())) * 31) + (this.year == null ? 0 : this.year.hashCode())) * 31) + this.popularity) * 31) + (this.status == null ? 0 : this.status.hashCode())) * 31) + (this.releaseDate != null ? this.releaseDate.hashCode() : 0)) * 31) + OneTouchTVParser$Month$$ExternalSyntheticBackport0.m3m(this.isSub);
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Month(_id=").append(this._id).append(", id=").append(this.id).append(", title=").append(this.title).append(", image=").append(this.image).append(", country=").append(this.country).append(", type=").append(this.type).append(", year=").append(this.year).append(", popularity=").append(this.popularity).append(", status=").append(this.status).append(", releaseDate=").append(this.releaseDate).append(", isSub=").append(this.isSub).append(')');
            return sb.toString();
        }

        public Month(@Nullable String _id, @Nullable String id, @Nullable String title, @Nullable String image, @Nullable String country, @Nullable String type, @Nullable String year, int popularity, @Nullable String status, @Nullable String releaseDate, boolean isSub) {
            this._id = _id;
            this.id = id;
            this.title = title;
            this.image = image;
            this.country = country;
            this.type = type;
            this.year = year;
            this.popularity = popularity;
            this.status = status;
            this.releaseDate = releaseDate;
            this.isSub = isSub;
        }

        public /* synthetic */ Month(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, String str8, String str9, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : str2, (i2 & 4) != 0 ? null : str3, (i2 & 8) != 0 ? null : str4, (i2 & 16) != 0 ? null : str5, (i2 & 32) != 0 ? null : str6, (i2 & 64) != 0 ? null : str7, (i2 & 128) != 0 ? 0 : i, (i2 & 256) != 0 ? null : str8, (i2 & 512) != 0 ? null : str9, (i2 & 1024) != 0 ? false : z);
        }

        @Nullable
        public final String get_id() {
            return this._id;
        }

        @Nullable
        public final String getId() {
            return this.id;
        }

        @Nullable
        public final String getTitle() {
            return this.title;
        }

        @Nullable
        public final String getImage() {
            return this.image;
        }

        @Nullable
        public final String getCountry() {
            return this.country;
        }

        @Nullable
        public final String getType() {
            return this.type;
        }

        @Nullable
        public final String getYear() {
            return this.year;
        }

        public final int getPopularity() {
            return this.popularity;
        }

        @Nullable
        public final String getStatus() {
            return this.status;
        }

        @Nullable
        public final String getReleaseDate() {
            return this.releaseDate;
        }

        public final boolean isSub() {
            return this.isSub;
        }
    }
}
