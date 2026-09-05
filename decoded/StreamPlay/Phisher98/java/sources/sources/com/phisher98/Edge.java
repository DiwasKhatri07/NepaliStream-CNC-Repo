package com.phisher98;

import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: StreamPlayParser.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/StreamPlay/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u0016\b\u0001\u0010\u0002\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J?\u0010\u0015\u001a\u00020\u00002\u0016\b\u0003\u0010\u0002\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0019\u001a\u00020\u001aHÖ\u0081\u0004J\n\u0010\u001b\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\r¨\u0006\u001c"}, d2 = {"Lcom/phisher98/Edge;", "", "id", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "_id", "name", "englishName", "nativeName", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getName", "getEnglishName", "getNativeName", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class Edge {

    @NotNull
    private final String englishName;

    @NotNull
    private final String id;

    @NotNull
    private final String name;

    @NotNull
    private final String nativeName;

    public static /* synthetic */ Edge copy$default(Edge edge, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = edge.id;
        }
        if ((i & 2) != 0) {
            str2 = edge.name;
        }
        if ((i & 4) != 0) {
            str3 = edge.englishName;
        }
        if ((i & 8) != 0) {
            str4 = edge.nativeName;
        }
        return edge.copy(str, str2, str3, str4);
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
    public final String getEnglishName() {
        return this.englishName;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getNativeName() {
        return this.nativeName;
    }

    @NotNull
    public final Edge copy(@JsonProperty("_id") @NotNull String id, @NotNull String name, @NotNull String englishName, @NotNull String nativeName) {
        return new Edge(id, name, englishName, nativeName);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Edge)) {
            return false;
        }
        Edge edge = (Edge) other;
        return Intrinsics.areEqual(this.id, edge.id) && Intrinsics.areEqual(this.name, edge.name) && Intrinsics.areEqual(this.englishName, edge.englishName) && Intrinsics.areEqual(this.nativeName, edge.nativeName);
    }

    public int hashCode() {
        return (((((this.id.hashCode() * 31) + this.name.hashCode()) * 31) + this.englishName.hashCode()) * 31) + this.nativeName.hashCode();
    }

    @NotNull
    public String toString() {
        return "Edge(id=" + this.id + ", name=" + this.name + ", englishName=" + this.englishName + ", nativeName=" + this.nativeName + ')';
    }

    public Edge(@JsonProperty("_id") @NotNull String id, @NotNull String name, @NotNull String englishName, @NotNull String nativeName) {
        this.id = id;
        this.name = name;
        this.englishName = englishName;
        this.nativeName = nativeName;
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
    public final String getEnglishName() {
        return this.englishName;
    }

    @NotNull
    public final String getNativeName() {
        return this.nativeName;
    }
}
