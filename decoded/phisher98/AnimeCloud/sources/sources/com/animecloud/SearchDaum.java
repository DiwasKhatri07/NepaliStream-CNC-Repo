package com.animecloud;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Parser.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/AnimeCloud/classes.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J-\u0010\u0012\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001J\u0014\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0016\u001a\u00020\u0017HÖ\u0081\u0004J\n\u0010\u0018\u001a\u00020\u0019HÖ\u0081\u0004R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\r¨\u0006\u001a"}, d2 = {"Lcom/animecloud/SearchDaum;", "", "data", "", "Lcom/animecloud/Search;", "pages", "", "status", "<init>", "(Ljava/util/List;JJ)V", "getData", "()Ljava/util/List;", "getPages", "()J", "getStatus", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "AnimeCloud"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class SearchDaum {

    @NotNull
    private final List<Search> data;
    private final long pages;
    private final long status;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SearchDaum copy$default(SearchDaum searchDaum, List list, long j, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = searchDaum.data;
        }
        if ((i & 2) != 0) {
            j = searchDaum.pages;
        }
        if ((i & 4) != 0) {
            j2 = searchDaum.status;
        }
        return searchDaum.copy(list, j, j2);
    }

    @NotNull
    public final List<Search> component1() {
        return this.data;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getPages() {
        return this.pages;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final long getStatus() {
        return this.status;
    }

    @NotNull
    public final SearchDaum copy(@NotNull List<Search> data, long pages, long status) {
        return new SearchDaum(data, pages, status);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SearchDaum)) {
            return false;
        }
        SearchDaum searchDaum = (SearchDaum) other;
        return Intrinsics.areEqual(this.data, searchDaum.data) && this.pages == searchDaum.pages && this.status == searchDaum.status;
    }

    public int hashCode() {
        return (((this.data.hashCode() * 31) + SearchDaum$$ExternalSyntheticBackport0.m14m(this.pages)) * 31) + SearchDaum$$ExternalSyntheticBackport0.m14m(this.status);
    }

    @NotNull
    public String toString() {
        return "SearchDaum(data=" + this.data + ", pages=" + this.pages + ", status=" + this.status + ')';
    }

    public SearchDaum(@NotNull List<Search> list, long pages, long status) {
        this.data = list;
        this.pages = pages;
        this.status = status;
    }

    @NotNull
    public final List<Search> getData() {
        return this.data;
    }

    public final long getPages() {
        return this.pages;
    }

    public final long getStatus() {
        return this.status;
    }
}
