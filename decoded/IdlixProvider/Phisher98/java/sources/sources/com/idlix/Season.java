package com.idlix;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: IdlixParser.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/IdlixProvider/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BI\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t¢\u0006\u0004\b\u000b\u0010\fJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0010J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0003JP\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010\u001cJ\u0014\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010 \u001a\u00020\u0005HÖ\u0081\u0004J\n\u0010!\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0019\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006\""}, d2 = {"Lcom/idlix/Season;", "", "id", "", "seasonNumber", "", "name", "posterPath", "episodes", "", "Lcom/idlix/Episode;", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getId", "()Ljava/lang/String;", "getSeasonNumber", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getName", "getPosterPath", "getEpisodes", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)Lcom/idlix/Season;", "equals", "", "other", "hashCode", "toString", "IdlixProvider"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class Season {

    @Nullable
    private final List<Episode> episodes;

    @Nullable
    private final String id;

    @Nullable
    private final String name;

    @Nullable
    private final String posterPath;

    @Nullable
    private final Integer seasonNumber;

    public Season() {
        this(null, null, null, null, null, 31, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Season copy$default(Season season, String str, Integer num, String str2, String str3, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = season.id;
        }
        if ((i & 2) != 0) {
            num = season.seasonNumber;
        }
        if ((i & 4) != 0) {
            str2 = season.name;
        }
        if ((i & 8) != 0) {
            str3 = season.posterPath;
        }
        if ((i & 16) != 0) {
            list = season.episodes;
        }
        List list2 = list;
        String str4 = str2;
        return season.copy(str, num, str4, str3, list2);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Integer getSeasonNumber() {
        return this.seasonNumber;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getName() {
        return this.name;
    }

    @Nullable
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getPosterPath() {
        return this.posterPath;
    }

    @Nullable
    public final List<Episode> component5() {
        return this.episodes;
    }

    @NotNull
    public final Season copy(@Nullable String id, @Nullable Integer seasonNumber, @Nullable String name, @Nullable String posterPath, @Nullable List<Episode> episodes) {
        return new Season(id, seasonNumber, name, posterPath, episodes);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Season)) {
            return false;
        }
        Season season = (Season) other;
        return Intrinsics.areEqual(this.id, season.id) && Intrinsics.areEqual(this.seasonNumber, season.seasonNumber) && Intrinsics.areEqual(this.name, season.name) && Intrinsics.areEqual(this.posterPath, season.posterPath) && Intrinsics.areEqual(this.episodes, season.episodes);
    }

    public int hashCode() {
        return ((((((((this.id == null ? 0 : this.id.hashCode()) * 31) + (this.seasonNumber == null ? 0 : this.seasonNumber.hashCode())) * 31) + (this.name == null ? 0 : this.name.hashCode())) * 31) + (this.posterPath == null ? 0 : this.posterPath.hashCode())) * 31) + (this.episodes != null ? this.episodes.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "Season(id=" + this.id + ", seasonNumber=" + this.seasonNumber + ", name=" + this.name + ", posterPath=" + this.posterPath + ", episodes=" + this.episodes + ')';
    }

    public Season(@Nullable String id, @Nullable Integer seasonNumber, @Nullable String name, @Nullable String posterPath, @Nullable List<Episode> list) {
        this.id = id;
        this.seasonNumber = seasonNumber;
        this.name = name;
        this.posterPath = posterPath;
        this.episodes = list;
    }

    public /* synthetic */ Season(String str, Integer num, String str2, String str3, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : num, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : list);
    }

    @Nullable
    public final String getId() {
        return this.id;
    }

    @Nullable
    public final Integer getSeasonNumber() {
        return this.seasonNumber;
    }

    @Nullable
    public final String getName() {
        return this.name;
    }

    @Nullable
    public final String getPosterPath() {
        return this.posterPath;
    }

    @Nullable
    public final List<Episode> getEpisodes() {
        return this.episodes;
    }
}
