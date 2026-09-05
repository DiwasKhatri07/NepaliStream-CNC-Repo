package com.OneTouchTV;

import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: OneTouchTVParser.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/OneTouchTV/classes.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b#\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u009f\u0001\u0012\u0018\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0018\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u0014\u0010\u0015J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010-\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010\u001fJ\u000b\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u00101\u001a\u0004\u0018\u00010\u0013HÆ\u0003¢\u0006\u0002\u0010$Jº\u0001\u00102\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\u0018\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00022\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÆ\u0001¢\u0006\u0002\u00103J\u0014\u00104\u001a\u00020\u00132\b\u00105\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u00106\u001a\u000207HÖ\u0081\u0004J\n\u00108\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0017R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0017R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0017R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0017R\u0015\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\n\n\u0002\u0010 \u001a\u0004\b\u001e\u0010\u001fR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0017R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0017R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0017R\u0015\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\n\n\u0002\u0010%\u001a\u0004\b\u0012\u0010$¨\u00069"}, d2 = {"Lcom/OneTouchTV/Recent;", "", "id", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "_id", "id2", "title", "image", "country", "type", "year", "popularity", "", "description", "status", "releaseDate", "isSub", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "getId", "()Ljava/lang/String;", "getId2", "getTitle", "getImage", "getCountry", "getType", "getYear", "getPopularity", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getDescription", "getStatus", "getReleaseDate", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)Lcom/OneTouchTV/Recent;", "equals", "other", "hashCode", "", "toString", "OneTouchTV"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class Recent {

    @Nullable
    private final String country;

    @Nullable
    private final String description;

    @Nullable
    private final String id;

    @Nullable
    private final String id2;

    @Nullable
    private final String image;

    @Nullable
    private final Boolean isSub;

    @Nullable
    private final Long popularity;

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

    public static /* synthetic */ Recent copy$default(Recent recent, String str, String str2, String str3, String str4, String str5, String str6, String str7, Long l, String str8, String str9, String str10, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            str = recent.id;
        }
        if ((i & 2) != 0) {
            str2 = recent.id2;
        }
        if ((i & 4) != 0) {
            str3 = recent.title;
        }
        if ((i & 8) != 0) {
            str4 = recent.image;
        }
        if ((i & 16) != 0) {
            str5 = recent.country;
        }
        if ((i & 32) != 0) {
            str6 = recent.type;
        }
        if ((i & 64) != 0) {
            str7 = recent.year;
        }
        if ((i & 128) != 0) {
            l = recent.popularity;
        }
        if ((i & 256) != 0) {
            str8 = recent.description;
        }
        if ((i & 512) != 0) {
            str9 = recent.status;
        }
        if ((i & 1024) != 0) {
            str10 = recent.releaseDate;
        }
        if ((i & 2048) != 0) {
            bool = recent.isSub;
        }
        String str11 = str10;
        Boolean bool2 = bool;
        String str12 = str8;
        String str13 = str9;
        String str14 = str7;
        Long l2 = l;
        String str15 = str5;
        String str16 = str6;
        return recent.copy(str, str2, str3, str4, str15, str16, str14, l2, str12, str13, str11, bool2);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    @Nullable
    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    @Nullable
    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getReleaseDate() {
        return this.releaseDate;
    }

    @Nullable
    /* JADX INFO: renamed from: component12, reason: from getter */
    public final Boolean getIsSub() {
        return this.isSub;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getId2() {
        return this.id2;
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

    @Nullable
    /* JADX INFO: renamed from: component8, reason: from getter */
    public final Long getPopularity() {
        return this.popularity;
    }

    @Nullable
    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    @NotNull
    public final Recent copy(@JsonProperty("_id") @Nullable String id, @JsonProperty("id") @Nullable String id2, @Nullable String title, @Nullable String image, @Nullable String country, @Nullable String type, @Nullable String year, @Nullable Long popularity, @Nullable String description, @Nullable String status, @Nullable String releaseDate, @Nullable Boolean isSub) {
        return new Recent(id, id2, title, image, country, type, year, popularity, description, status, releaseDate, isSub);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Recent)) {
            return false;
        }
        Recent recent = (Recent) other;
        return Intrinsics.areEqual(this.id, recent.id) && Intrinsics.areEqual(this.id2, recent.id2) && Intrinsics.areEqual(this.title, recent.title) && Intrinsics.areEqual(this.image, recent.image) && Intrinsics.areEqual(this.country, recent.country) && Intrinsics.areEqual(this.type, recent.type) && Intrinsics.areEqual(this.year, recent.year) && Intrinsics.areEqual(this.popularity, recent.popularity) && Intrinsics.areEqual(this.description, recent.description) && Intrinsics.areEqual(this.status, recent.status) && Intrinsics.areEqual(this.releaseDate, recent.releaseDate) && Intrinsics.areEqual(this.isSub, recent.isSub);
    }

    public int hashCode() {
        return ((((((((((((((((((((((this.id == null ? 0 : this.id.hashCode()) * 31) + (this.id2 == null ? 0 : this.id2.hashCode())) * 31) + (this.title == null ? 0 : this.title.hashCode())) * 31) + (this.image == null ? 0 : this.image.hashCode())) * 31) + (this.country == null ? 0 : this.country.hashCode())) * 31) + (this.type == null ? 0 : this.type.hashCode())) * 31) + (this.year == null ? 0 : this.year.hashCode())) * 31) + (this.popularity == null ? 0 : this.popularity.hashCode())) * 31) + (this.description == null ? 0 : this.description.hashCode())) * 31) + (this.status == null ? 0 : this.status.hashCode())) * 31) + (this.releaseDate == null ? 0 : this.releaseDate.hashCode())) * 31) + (this.isSub != null ? this.isSub.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Recent(id=").append(this.id).append(", id2=").append(this.id2).append(", title=").append(this.title).append(", image=").append(this.image).append(", country=").append(this.country).append(", type=").append(this.type).append(", year=").append(this.year).append(", popularity=").append(this.popularity).append(", description=").append(this.description).append(", status=").append(this.status).append(", releaseDate=").append(this.releaseDate).append(", isSub=");
        sb.append(this.isSub).append(')');
        return sb.toString();
    }

    public Recent(@JsonProperty("_id") @Nullable String id, @JsonProperty("id") @Nullable String id2, @Nullable String title, @Nullable String image, @Nullable String country, @Nullable String type, @Nullable String year, @Nullable Long popularity, @Nullable String description, @Nullable String status, @Nullable String releaseDate, @Nullable Boolean isSub) {
        this.id = id;
        this.id2 = id2;
        this.title = title;
        this.image = image;
        this.country = country;
        this.type = type;
        this.year = year;
        this.popularity = popularity;
        this.description = description;
        this.status = status;
        this.releaseDate = releaseDate;
        this.isSub = isSub;
    }

    @Nullable
    public final String getId() {
        return this.id;
    }

    @Nullable
    public final String getId2() {
        return this.id2;
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

    @Nullable
    public final Long getPopularity() {
        return this.popularity;
    }

    @Nullable
    public final String getDescription() {
        return this.description;
    }

    @Nullable
    public final String getStatus() {
        return this.status;
    }

    @Nullable
    public final String getReleaseDate() {
        return this.releaseDate;
    }

    @Nullable
    public final Boolean isSub() {
        return this.isSub;
    }
}
