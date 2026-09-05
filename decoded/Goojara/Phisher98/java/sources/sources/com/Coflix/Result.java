package com.Coflix;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Parser.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/Goojara/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b&\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Ba\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u0005¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0005HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\t\u0010\"\u001a\u00020\u0005HÆ\u0003J\t\u0010#\u001a\u00020\u0005HÆ\u0003J\t\u0010$\u001a\u00020\u0005HÆ\u0003J\t\u0010%\u001a\u00020\u0005HÆ\u0003J\t\u0010&\u001a\u00020\u0005HÆ\u0003J\t\u0010'\u001a\u00020\u0005HÆ\u0003J\t\u0010(\u001a\u00020\u0005HÆ\u0003J\t\u0010)\u001a\u00020\u0005HÆ\u0003Jy\u0010*\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u0005HÆ\u0001J\u0014\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010.\u001a\u00020/HÖ\u0081\u0004J\n\u00100\u001a\u00020\u0005HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0014R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0014R\u0011\u0010\u000b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0014R\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0014R\u0011\u0010\r\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0014R\u0011\u0010\u000e\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0014¨\u00061"}, d2 = {"Lcom/Coflix/Result;", "", "uuid", "", "name", "", "ranking", "url", "path", "ts", "release", "director", "casts", "slug", "excerpt", "<init>", "(JLjava/lang/String;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getUuid", "()J", "getName", "()Ljava/lang/String;", "getRanking", "()Ljava/lang/Object;", "getUrl", "getPath", "getTs", "getRelease", "getDirector", "getCasts", "getSlug", "getExcerpt", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "equals", "", "other", "hashCode", "", "toString", "Goojara"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class Result {

    @NotNull
    private final String casts;

    @NotNull
    private final String director;

    @NotNull
    private final String excerpt;

    @NotNull
    private final String name;

    @NotNull
    private final String path;

    @Nullable
    private final Object ranking;

    @NotNull
    private final String release;

    @NotNull
    private final String slug;

    @NotNull
    private final String ts;

    @NotNull
    private final String url;
    private final long uuid;

    public static /* synthetic */ Result copy$default(Result result, long j, String str, Object obj, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, int i, Object obj2) {
        if ((i & 1) != 0) {
            j = result.uuid;
        }
        return result.copy(j, (i & 2) != 0 ? result.name : str, (i & 4) != 0 ? result.ranking : obj, (i & 8) != 0 ? result.url : str2, (i & 16) != 0 ? result.path : str3, (i & 32) != 0 ? result.ts : str4, (i & 64) != 0 ? result.release : str5, (i & 128) != 0 ? result.director : str6, (i & 256) != 0 ? result.casts : str7, (i & 512) != 0 ? result.slug : str8, (i & 1024) != 0 ? result.excerpt : str9);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getUuid() {
        return this.uuid;
    }

    @NotNull
    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getSlug() {
        return this.slug;
    }

    @NotNull
    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getExcerpt() {
        return this.excerpt;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Object getRanking() {
        return this.ranking;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    @NotNull
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getPath() {
        return this.path;
    }

    @NotNull
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getTs() {
        return this.ts;
    }

    @NotNull
    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getRelease() {
        return this.release;
    }

    @NotNull
    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getDirector() {
        return this.director;
    }

    @NotNull
    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getCasts() {
        return this.casts;
    }

    @NotNull
    public final Result copy(long uuid, @NotNull String name, @Nullable Object ranking, @NotNull String url, @NotNull String path, @NotNull String ts, @NotNull String release, @NotNull String director, @NotNull String casts, @NotNull String slug, @NotNull String excerpt) {
        return new Result(uuid, name, ranking, url, path, ts, release, director, casts, slug, excerpt);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Result)) {
            return false;
        }
        Result result = (Result) other;
        return this.uuid == result.uuid && Intrinsics.areEqual(this.name, result.name) && Intrinsics.areEqual(this.ranking, result.ranking) && Intrinsics.areEqual(this.url, result.url) && Intrinsics.areEqual(this.path, result.path) && Intrinsics.areEqual(this.ts, result.ts) && Intrinsics.areEqual(this.release, result.release) && Intrinsics.areEqual(this.director, result.director) && Intrinsics.areEqual(this.casts, result.casts) && Intrinsics.areEqual(this.slug, result.slug) && Intrinsics.areEqual(this.excerpt, result.excerpt);
    }

    public int hashCode() {
        return (((((((((((((((((((Result$$ExternalSyntheticBackport0.m3m(this.uuid) * 31) + this.name.hashCode()) * 31) + (this.ranking == null ? 0 : this.ranking.hashCode())) * 31) + this.url.hashCode()) * 31) + this.path.hashCode()) * 31) + this.ts.hashCode()) * 31) + this.release.hashCode()) * 31) + this.director.hashCode()) * 31) + this.casts.hashCode()) * 31) + this.slug.hashCode()) * 31) + this.excerpt.hashCode();
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Result(uuid=").append(this.uuid).append(", name=").append(this.name).append(", ranking=").append(this.ranking).append(", url=").append(this.url).append(", path=").append(this.path).append(", ts=").append(this.ts).append(", release=").append(this.release).append(", director=").append(this.director).append(", casts=").append(this.casts).append(", slug=").append(this.slug).append(", excerpt=").append(this.excerpt).append(')');
        return sb.toString();
    }

    public Result(long uuid, @NotNull String name, @Nullable Object ranking, @NotNull String url, @NotNull String path, @NotNull String ts, @NotNull String release, @NotNull String director, @NotNull String casts, @NotNull String slug, @NotNull String excerpt) {
        this.uuid = uuid;
        this.name = name;
        this.ranking = ranking;
        this.url = url;
        this.path = path;
        this.ts = ts;
        this.release = release;
        this.director = director;
        this.casts = casts;
        this.slug = slug;
        this.excerpt = excerpt;
    }

    public final long getUuid() {
        return this.uuid;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @Nullable
    public final Object getRanking() {
        return this.ranking;
    }

    @NotNull
    public final String getUrl() {
        return this.url;
    }

    @NotNull
    public final String getPath() {
        return this.path;
    }

    @NotNull
    public final String getTs() {
        return this.ts;
    }

    @NotNull
    public final String getRelease() {
        return this.release;
    }

    @NotNull
    public final String getDirector() {
        return this.director;
    }

    @NotNull
    public final String getCasts() {
        return this.casts;
    }

    @NotNull
    public final String getSlug() {
        return this.slug;
    }

    @NotNull
    public final String getExcerpt() {
        return this.excerpt;
    }
}
