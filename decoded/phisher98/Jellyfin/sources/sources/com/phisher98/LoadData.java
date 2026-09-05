package com.phisher98;

import com.lagradost.cloudstream3.TvType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: JellyfinParser.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/Jellyfin/classes.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J;\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001b\u001a\u00020\u001cHÖ\u0081\u0004J\n\u0010\u001d\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006\u001e"}, d2 = {"Lcom/phisher98/LoadData;", "", "name", "", "posterurl", "type", "Lcom/lagradost/cloudstream3/TvType;", "id", "userid", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/lagradost/cloudstream3/TvType;Ljava/lang/String;Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "getPosterurl", "getType", "()Lcom/lagradost/cloudstream3/TvType;", "getId", "getUserid", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "Jellyfin"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class LoadData {

    @NotNull
    private final String id;

    @NotNull
    private final String name;

    @NotNull
    private final String posterurl;

    @NotNull
    private final TvType type;

    @NotNull
    private final String userid;

    public static /* synthetic */ LoadData copy$default(LoadData loadData, String str, String str2, TvType tvType, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = loadData.name;
        }
        if ((i & 2) != 0) {
            str2 = loadData.posterurl;
        }
        if ((i & 4) != 0) {
            tvType = loadData.type;
        }
        if ((i & 8) != 0) {
            str3 = loadData.id;
        }
        if ((i & 16) != 0) {
            str4 = loadData.userid;
        }
        String str5 = str4;
        TvType tvType2 = tvType;
        return loadData.copy(str, str2, tvType2, str3, str5);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getPosterurl() {
        return this.posterurl;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final TvType getType() {
        return this.type;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getId() {
        return this.id;
    }

    @NotNull
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getUserid() {
        return this.userid;
    }

    @NotNull
    public final LoadData copy(@NotNull String name, @NotNull String posterurl, @NotNull TvType type, @NotNull String id, @NotNull String userid) {
        return new LoadData(name, posterurl, type, id, userid);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LoadData)) {
            return false;
        }
        LoadData loadData = (LoadData) other;
        return Intrinsics.areEqual(this.name, loadData.name) && Intrinsics.areEqual(this.posterurl, loadData.posterurl) && this.type == loadData.type && Intrinsics.areEqual(this.id, loadData.id) && Intrinsics.areEqual(this.userid, loadData.userid);
    }

    public int hashCode() {
        return (((((((this.name.hashCode() * 31) + this.posterurl.hashCode()) * 31) + this.type.hashCode()) * 31) + this.id.hashCode()) * 31) + this.userid.hashCode();
    }

    @NotNull
    public String toString() {
        return "LoadData(name=" + this.name + ", posterurl=" + this.posterurl + ", type=" + this.type + ", id=" + this.id + ", userid=" + this.userid + ')';
    }

    public LoadData(@NotNull String name, @NotNull String posterurl, @NotNull TvType type, @NotNull String id, @NotNull String userid) {
        this.name = name;
        this.posterurl = posterurl;
        this.type = type;
        this.id = id;
        this.userid = userid;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @NotNull
    public final String getPosterurl() {
        return this.posterurl;
    }

    @NotNull
    public final TvType getType() {
        return this.type;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    @NotNull
    public final String getUserid() {
        return this.userid;
    }
}
