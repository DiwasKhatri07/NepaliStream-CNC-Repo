package com.MPlayer;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Parser.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/MPlayerProvider/classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004J\n\u0010\u0015\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/MPlayer/MovieGenresDetail;", "", "id", "", "name", "webUrl", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getName", "getWebUrl", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "MPlayerProvider"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class MovieGenresDetail {

    @NotNull
    private final String id;

    @NotNull
    private final String name;

    @NotNull
    private final String webUrl;

    public static /* synthetic */ MovieGenresDetail copy$default(MovieGenresDetail movieGenresDetail, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = movieGenresDetail.id;
        }
        if ((i & 2) != 0) {
            str2 = movieGenresDetail.name;
        }
        if ((i & 4) != 0) {
            str3 = movieGenresDetail.webUrl;
        }
        return movieGenresDetail.copy(str, str2, str3);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getWebUrl() {
        return this.webUrl;
    }

    @NotNull
    public final MovieGenresDetail copy(@NotNull String id, @NotNull String name, @NotNull String webUrl) {
        return new MovieGenresDetail(id, name, webUrl);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MovieGenresDetail)) {
            return false;
        }
        MovieGenresDetail movieGenresDetail = (MovieGenresDetail) other;
        return Intrinsics.areEqual(this.id, movieGenresDetail.id) && Intrinsics.areEqual(this.name, movieGenresDetail.name) && Intrinsics.areEqual(this.webUrl, movieGenresDetail.webUrl);
    }

    public int hashCode() {
        return (((this.id.hashCode() * 31) + this.name.hashCode()) * 31) + this.webUrl.hashCode();
    }

    @NotNull
    public String toString() {
        return "MovieGenresDetail(id=" + this.id + ", name=" + this.name + ", webUrl=" + this.webUrl + ')';
    }

    public MovieGenresDetail(@NotNull String id, @NotNull String name, @NotNull String webUrl) {
        this.id = id;
        this.name = name;
        this.webUrl = webUrl;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @NotNull
    public final String getWebUrl() {
        return this.webUrl;
    }
}
