package com.MovieBlast;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: MovieBlastParser.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/MovieBlast/classes.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0014\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/MovieBlast/SearchRoot;", "", "search", "", "Lcom/MovieBlast/Search;", "<init>", "(Ljava/util/List;)V", "getSearch", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "MovieBlast"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class SearchRoot {

    @NotNull
    private final List<Search> search;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SearchRoot copy$default(SearchRoot searchRoot, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = searchRoot.search;
        }
        return searchRoot.copy(list);
    }

    @NotNull
    public final List<Search> component1() {
        return this.search;
    }

    @NotNull
    public final SearchRoot copy(@NotNull List<Search> search) {
        return new SearchRoot(search);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof SearchRoot) && Intrinsics.areEqual(this.search, ((SearchRoot) other).search);
    }

    public int hashCode() {
        return this.search.hashCode();
    }

    @NotNull
    public String toString() {
        return "SearchRoot(search=" + this.search + ')';
    }

    public SearchRoot(@NotNull List<Search> list) {
        this.search = list;
    }

    @NotNull
    public final List<Search> getSearch() {
        return this.search;
    }
}
