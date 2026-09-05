package com.Coflix;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Parser.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/Goojara/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u001d\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u001f\u001a\u00020\bHÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u000bHÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J_\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u0003HÆ\u0001J\u0014\u0010&\u001a\u00020\b2\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010(\u001a\u00020)HÖ\u0081\u0004J\n\u0010*\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0012R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0012R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0012¨\u0006+"}, d2 = {"Lcom/Coflix/Response;", "", "res", "", "results", "", "Lcom/Coflix/Result;", "next", "", "page", "total", "", "genres", "years", "sort", "<init>", "(Ljava/lang/String;Ljava/util/List;ZLjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getRes", "()Ljava/lang/String;", "getResults", "()Ljava/util/List;", "getNext", "()Z", "getPage", "getTotal", "()J", "getGenres", "getYears", "getSort", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", "", "toString", "Goojara"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class Response {

    @NotNull
    private final String genres;
    private final boolean next;

    @NotNull
    private final String page;

    @NotNull
    private final String res;

    @NotNull
    private final List<Result> results;

    @NotNull
    private final String sort;
    private final long total;

    @NotNull
    private final String years;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Response copy$default(Response response, String str, List list, boolean z, String str2, long j, String str3, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = response.res;
        }
        if ((i & 2) != 0) {
            list = response.results;
        }
        if ((i & 4) != 0) {
            z = response.next;
        }
        if ((i & 8) != 0) {
            str2 = response.page;
        }
        if ((i & 16) != 0) {
            j = response.total;
        }
        if ((i & 32) != 0) {
            str3 = response.genres;
        }
        if ((i & 64) != 0) {
            str4 = response.years;
        }
        if ((i & 128) != 0) {
            str5 = response.sort;
        }
        String str6 = str5;
        String str7 = str3;
        long j2 = j;
        boolean z2 = z;
        String str8 = str2;
        return response.copy(str, list, z2, str8, j2, str7, str4, str6);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getRes() {
        return this.res;
    }

    @NotNull
    public final List<Result> component2() {
        return this.results;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getNext() {
        return this.next;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getPage() {
        return this.page;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final long getTotal() {
        return this.total;
    }

    @NotNull
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getGenres() {
        return this.genres;
    }

    @NotNull
    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getYears() {
        return this.years;
    }

    @NotNull
    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getSort() {
        return this.sort;
    }

    @NotNull
    public final Response copy(@NotNull String res, @NotNull List<Result> results, boolean next, @NotNull String page, long total, @NotNull String genres, @NotNull String years, @NotNull String sort) {
        return new Response(res, results, next, page, total, genres, years, sort);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Response)) {
            return false;
        }
        Response response = (Response) other;
        return Intrinsics.areEqual(this.res, response.res) && Intrinsics.areEqual(this.results, response.results) && this.next == response.next && Intrinsics.areEqual(this.page, response.page) && this.total == response.total && Intrinsics.areEqual(this.genres, response.genres) && Intrinsics.areEqual(this.years, response.years) && Intrinsics.areEqual(this.sort, response.sort);
    }

    public int hashCode() {
        return (((((((((((((this.res.hashCode() * 31) + this.results.hashCode()) * 31) + Response$$ExternalSyntheticBackport0.m1m(this.next)) * 31) + this.page.hashCode()) * 31) + Response$$ExternalSyntheticBackport1.m2m(this.total)) * 31) + this.genres.hashCode()) * 31) + this.years.hashCode()) * 31) + this.sort.hashCode();
    }

    @NotNull
    public String toString() {
        return "Response(res=" + this.res + ", results=" + this.results + ", next=" + this.next + ", page=" + this.page + ", total=" + this.total + ", genres=" + this.genres + ", years=" + this.years + ", sort=" + this.sort + ')';
    }

    public Response(@NotNull String res, @NotNull List<Result> list, boolean next, @NotNull String page, long total, @NotNull String genres, @NotNull String years, @NotNull String sort) {
        this.res = res;
        this.results = list;
        this.next = next;
        this.page = page;
        this.total = total;
        this.genres = genres;
        this.years = years;
        this.sort = sort;
    }

    @NotNull
    public final String getRes() {
        return this.res;
    }

    @NotNull
    public final List<Result> getResults() {
        return this.results;
    }

    public final boolean getNext() {
        return this.next;
    }

    @NotNull
    public final String getPage() {
        return this.page;
    }

    public final long getTotal() {
        return this.total;
    }

    @NotNull
    public final String getGenres() {
        return this.genres;
    }

    @NotNull
    public final String getYears() {
        return this.years;
    }

    @NotNull
    public final String getSort() {
        return this.sort;
    }
}
