package com.Donghuastream;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Donghuastreamparser.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/Donghuastream/classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004J\n\u0010\u0015\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/Donghuastream/Query;", "", "source", "", "id", "alt", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getSource", "()Ljava/lang/String;", "getId", "getAlt", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "Donghuastream"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class Query {

    @NotNull
    private final String alt;

    @NotNull
    private final String id;

    @NotNull
    private final String source;

    public static /* synthetic */ Query copy$default(Query query, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = query.source;
        }
        if ((i & 2) != 0) {
            str2 = query.id;
        }
        if ((i & 4) != 0) {
            str3 = query.alt;
        }
        return query.copy(str, str2, str3);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getSource() {
        return this.source;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getId() {
        return this.id;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getAlt() {
        return this.alt;
    }

    @NotNull
    public final Query copy(@NotNull String source, @NotNull String id, @NotNull String alt) {
        return new Query(source, id, alt);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Query)) {
            return false;
        }
        Query query = (Query) other;
        return Intrinsics.areEqual(this.source, query.source) && Intrinsics.areEqual(this.id, query.id) && Intrinsics.areEqual(this.alt, query.alt);
    }

    public int hashCode() {
        return (((this.source.hashCode() * 31) + this.id.hashCode()) * 31) + this.alt.hashCode();
    }

    @NotNull
    public String toString() {
        return "Query(source=" + this.source + ", id=" + this.id + ", alt=" + this.alt + ')';
    }

    public Query(@NotNull String source, @NotNull String id, @NotNull String alt) {
        this.source = source;
        this.id = id;
        this.alt = alt;
    }

    @NotNull
    public final String getSource() {
        return this.source;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    @NotNull
    public final String getAlt() {
        return this.alt;
    }
}
