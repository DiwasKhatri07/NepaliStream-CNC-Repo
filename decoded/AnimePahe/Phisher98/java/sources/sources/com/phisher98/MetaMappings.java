package com.phisher98;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Utils.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/AnimePahe/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BO\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003JQ\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001c\u001a\u00020\u001dHÖ\u0081\u0004J\n\u0010\u001e\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006\u001f"}, d2 = {"Lcom/phisher98/MetaMappings;", "", "themoviedb_id", "", "thetvdb_id", "imdb_id", "mal_id", "anilist_id", "kitsu_id", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getThemoviedb_id", "()Ljava/lang/String;", "getThetvdb_id", "getImdb_id", "getMal_id", "getAnilist_id", "getKitsu_id", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "AnimePahe"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class MetaMappings {

    @Nullable
    private final String anilist_id;

    @Nullable
    private final String imdb_id;

    @Nullable
    private final String kitsu_id;

    @Nullable
    private final String mal_id;

    @Nullable
    private final String themoviedb_id;

    @Nullable
    private final String thetvdb_id;

    public MetaMappings() {
        this(null, null, null, null, null, null, 63, null);
    }

    public static /* synthetic */ MetaMappings copy$default(MetaMappings metaMappings, String str, String str2, String str3, String str4, String str5, String str6, int i, Object obj) {
        if ((i & 1) != 0) {
            str = metaMappings.themoviedb_id;
        }
        if ((i & 2) != 0) {
            str2 = metaMappings.thetvdb_id;
        }
        if ((i & 4) != 0) {
            str3 = metaMappings.imdb_id;
        }
        if ((i & 8) != 0) {
            str4 = metaMappings.mal_id;
        }
        if ((i & 16) != 0) {
            str5 = metaMappings.anilist_id;
        }
        if ((i & 32) != 0) {
            str6 = metaMappings.kitsu_id;
        }
        String str7 = str5;
        String str8 = str6;
        return metaMappings.copy(str, str2, str3, str4, str7, str8);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getThemoviedb_id() {
        return this.themoviedb_id;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getThetvdb_id() {
        return this.thetvdb_id;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getImdb_id() {
        return this.imdb_id;
    }

    @Nullable
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getMal_id() {
        return this.mal_id;
    }

    @Nullable
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getAnilist_id() {
        return this.anilist_id;
    }

    @Nullable
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getKitsu_id() {
        return this.kitsu_id;
    }

    @NotNull
    public final MetaMappings copy(@Nullable String themoviedb_id, @Nullable String thetvdb_id, @Nullable String imdb_id, @Nullable String mal_id, @Nullable String anilist_id, @Nullable String kitsu_id) {
        return new MetaMappings(themoviedb_id, thetvdb_id, imdb_id, mal_id, anilist_id, kitsu_id);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MetaMappings)) {
            return false;
        }
        MetaMappings metaMappings = (MetaMappings) other;
        return Intrinsics.areEqual(this.themoviedb_id, metaMappings.themoviedb_id) && Intrinsics.areEqual(this.thetvdb_id, metaMappings.thetvdb_id) && Intrinsics.areEqual(this.imdb_id, metaMappings.imdb_id) && Intrinsics.areEqual(this.mal_id, metaMappings.mal_id) && Intrinsics.areEqual(this.anilist_id, metaMappings.anilist_id) && Intrinsics.areEqual(this.kitsu_id, metaMappings.kitsu_id);
    }

    public int hashCode() {
        return ((((((((((this.themoviedb_id == null ? 0 : this.themoviedb_id.hashCode()) * 31) + (this.thetvdb_id == null ? 0 : this.thetvdb_id.hashCode())) * 31) + (this.imdb_id == null ? 0 : this.imdb_id.hashCode())) * 31) + (this.mal_id == null ? 0 : this.mal_id.hashCode())) * 31) + (this.anilist_id == null ? 0 : this.anilist_id.hashCode())) * 31) + (this.kitsu_id != null ? this.kitsu_id.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "MetaMappings(themoviedb_id=" + this.themoviedb_id + ", thetvdb_id=" + this.thetvdb_id + ", imdb_id=" + this.imdb_id + ", mal_id=" + this.mal_id + ", anilist_id=" + this.anilist_id + ", kitsu_id=" + this.kitsu_id + ')';
    }

    public MetaMappings(@Nullable String themoviedb_id, @Nullable String thetvdb_id, @Nullable String imdb_id, @Nullable String mal_id, @Nullable String anilist_id, @Nullable String kitsu_id) {
        this.themoviedb_id = themoviedb_id;
        this.thetvdb_id = thetvdb_id;
        this.imdb_id = imdb_id;
        this.mal_id = mal_id;
        this.anilist_id = anilist_id;
        this.kitsu_id = kitsu_id;
    }

    public /* synthetic */ MetaMappings(String str, String str2, String str3, String str4, String str5, String str6, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : str6);
    }

    @Nullable
    public final String getThemoviedb_id() {
        return this.themoviedb_id;
    }

    @Nullable
    public final String getThetvdb_id() {
        return this.thetvdb_id;
    }

    @Nullable
    public final String getImdb_id() {
        return this.imdb_id;
    }

    @Nullable
    public final String getMal_id() {
        return this.mal_id;
    }

    @Nullable
    public final String getAnilist_id() {
        return this.anilist_id;
    }

    @Nullable
    public final String getKitsu_id() {
        return this.kitsu_id;
    }
}
