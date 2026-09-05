package com.phisher98;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: TorraStreamParser.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/TorraStream/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0011\u001a\u00020\u0012HÖ\u0081\u0004J\n\u0010\u0013\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/phisher98/Service;", "", "id", "", "cached", "", "<init>", "(Ljava/lang/String;Z)V", "getId", "()Ljava/lang/String;", "getCached", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "TorraStream"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class Service {
    private final boolean cached;

    @NotNull
    private final String id;

    public static /* synthetic */ Service copy$default(Service service, String str, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = service.id;
        }
        if ((i & 2) != 0) {
            z = service.cached;
        }
        return service.copy(str, z);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getCached() {
        return this.cached;
    }

    @NotNull
    public final Service copy(@NotNull String id, boolean cached) {
        return new Service(id, cached);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Service)) {
            return false;
        }
        Service service = (Service) other;
        return Intrinsics.areEqual(this.id, service.id) && this.cached == service.cached;
    }

    public int hashCode() {
        return (this.id.hashCode() * 31) + Service$$ExternalSyntheticBackport0.m5m(this.cached);
    }

    @NotNull
    public String toString() {
        return "Service(id=" + this.id + ", cached=" + this.cached + ')';
    }

    public Service(@NotNull String id, boolean cached) {
        this.id = id;
        this.cached = cached;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    public final boolean getCached() {
        return this.cached;
    }
}
