package com.OneTouchTV;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: OneTouchTVParser.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/OneTouchTV/classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0019\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BW\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u0016Jn\u0010 \u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0002\u0010!J\u0014\u0010\"\u001a\u00020\u000b2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010$\u001a\u00020%HÖ\u0081\u0004J\n\u0010&\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0015\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\n\u0010\u0016¨\u0006'"}, d2 = {"Lcom/OneTouchTV/CleanMedia;", "", "id", "", "title", "image", "country", "type", "year", "status", "isSub", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "getId", "()Ljava/lang/String;", "getTitle", "getImage", "getCountry", "getType", "getYear", "getStatus", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)Lcom/OneTouchTV/CleanMedia;", "equals", "other", "hashCode", "", "toString", "OneTouchTV"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class CleanMedia {

    @Nullable
    private final String country;

    @Nullable
    private final String id;

    @Nullable
    private final String image;

    @Nullable
    private final Boolean isSub;

    @Nullable
    private final String status;

    @Nullable
    private final String title;

    @Nullable
    private final String type;

    @Nullable
    private final String year;

    public static /* synthetic */ CleanMedia copy$default(CleanMedia cleanMedia, String str, String str2, String str3, String str4, String str5, String str6, String str7, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            str = cleanMedia.id;
        }
        if ((i & 2) != 0) {
            str2 = cleanMedia.title;
        }
        if ((i & 4) != 0) {
            str3 = cleanMedia.image;
        }
        if ((i & 8) != 0) {
            str4 = cleanMedia.country;
        }
        if ((i & 16) != 0) {
            str5 = cleanMedia.type;
        }
        if ((i & 32) != 0) {
            str6 = cleanMedia.year;
        }
        if ((i & 64) != 0) {
            str7 = cleanMedia.status;
        }
        if ((i & 128) != 0) {
            bool = cleanMedia.isSub;
        }
        String str8 = str7;
        Boolean bool2 = bool;
        String str9 = str5;
        String str10 = str6;
        return cleanMedia.copy(str, str2, str3, str4, str9, str10, str8, bool2);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getImage() {
        return this.image;
    }

    @Nullable
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getCountry() {
        return this.country;
    }

    @Nullable
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getType() {
        return this.type;
    }

    @Nullable
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getYear() {
        return this.year;
    }

    @Nullable
    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    @Nullable
    /* JADX INFO: renamed from: component8, reason: from getter */
    public final Boolean getIsSub() {
        return this.isSub;
    }

    @NotNull
    public final CleanMedia copy(@Nullable String id, @Nullable String title, @Nullable String image, @Nullable String country, @Nullable String type, @Nullable String year, @Nullable String status, @Nullable Boolean isSub) {
        return new CleanMedia(id, title, image, country, type, year, status, isSub);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CleanMedia)) {
            return false;
        }
        CleanMedia cleanMedia = (CleanMedia) other;
        return Intrinsics.areEqual(this.id, cleanMedia.id) && Intrinsics.areEqual(this.title, cleanMedia.title) && Intrinsics.areEqual(this.image, cleanMedia.image) && Intrinsics.areEqual(this.country, cleanMedia.country) && Intrinsics.areEqual(this.type, cleanMedia.type) && Intrinsics.areEqual(this.year, cleanMedia.year) && Intrinsics.areEqual(this.status, cleanMedia.status) && Intrinsics.areEqual(this.isSub, cleanMedia.isSub);
    }

    public int hashCode() {
        return ((((((((((((((this.id == null ? 0 : this.id.hashCode()) * 31) + (this.title == null ? 0 : this.title.hashCode())) * 31) + (this.image == null ? 0 : this.image.hashCode())) * 31) + (this.country == null ? 0 : this.country.hashCode())) * 31) + (this.type == null ? 0 : this.type.hashCode())) * 31) + (this.year == null ? 0 : this.year.hashCode())) * 31) + (this.status == null ? 0 : this.status.hashCode())) * 31) + (this.isSub != null ? this.isSub.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "CleanMedia(id=" + this.id + ", title=" + this.title + ", image=" + this.image + ", country=" + this.country + ", type=" + this.type + ", year=" + this.year + ", status=" + this.status + ", isSub=" + this.isSub + ')';
    }

    public CleanMedia(@Nullable String id, @Nullable String title, @Nullable String image, @Nullable String country, @Nullable String type, @Nullable String year, @Nullable String status, @Nullable Boolean isSub) {
        this.id = id;
        this.title = title;
        this.image = image;
        this.country = country;
        this.type = type;
        this.year = year;
        this.status = status;
        this.isSub = isSub;
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

    @Nullable
    public final String getStatus() {
        return this.status;
    }

    @Nullable
    public final Boolean isSub() {
        return this.isSub;
    }
}
