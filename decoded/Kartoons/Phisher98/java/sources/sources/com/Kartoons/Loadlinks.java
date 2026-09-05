package com.Kartoons;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: KartoonsParser.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/Kartoons/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J&\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0010J\u0014\u0010\u0011\u001a\u00020\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004J\n\u0010\u0015\u001a\u00020\u0016HÖ\u0081\u0004R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/Kartoons/Loadlinks;", "", "success", "", "data", "Lcom/Kartoons/LoadlinksData;", "<init>", "(Ljava/lang/Boolean;Lcom/Kartoons/LoadlinksData;)V", "getSuccess", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getData", "()Lcom/Kartoons/LoadlinksData;", "component1", "component2", "copy", "(Ljava/lang/Boolean;Lcom/Kartoons/LoadlinksData;)Lcom/Kartoons/Loadlinks;", "equals", "other", "hashCode", "", "toString", "", "Kartoons"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class Loadlinks {

    @Nullable
    private final LoadlinksData data;

    @Nullable
    private final Boolean success;

    /* JADX WARN: Multi-variable type inference failed */
    public Loadlinks() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ Loadlinks copy$default(Loadlinks loadlinks, Boolean bool, LoadlinksData loadlinksData, int i, Object obj) {
        if ((i & 1) != 0) {
            bool = loadlinks.success;
        }
        if ((i & 2) != 0) {
            loadlinksData = loadlinks.data;
        }
        return loadlinks.copy(bool, loadlinksData);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Boolean getSuccess() {
        return this.success;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final LoadlinksData getData() {
        return this.data;
    }

    @NotNull
    public final Loadlinks copy(@Nullable Boolean success, @Nullable LoadlinksData data) {
        return new Loadlinks(success, data);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Loadlinks)) {
            return false;
        }
        Loadlinks loadlinks = (Loadlinks) other;
        return Intrinsics.areEqual(this.success, loadlinks.success) && Intrinsics.areEqual(this.data, loadlinks.data);
    }

    public int hashCode() {
        return ((this.success == null ? 0 : this.success.hashCode()) * 31) + (this.data != null ? this.data.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "Loadlinks(success=" + this.success + ", data=" + this.data + ')';
    }

    public Loadlinks(@Nullable Boolean success, @Nullable LoadlinksData data) {
        this.success = success;
        this.data = data;
    }

    public /* synthetic */ Loadlinks(Boolean bool, LoadlinksData loadlinksData, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : bool, (i & 2) != 0 ? null : loadlinksData);
    }

    @Nullable
    public final Boolean getSuccess() {
        return this.success;
    }

    @Nullable
    public final LoadlinksData getData() {
        return this.data;
    }
}
