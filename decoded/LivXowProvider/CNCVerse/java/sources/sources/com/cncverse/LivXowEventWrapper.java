package com.cncverse;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: LivXowProviderManager.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/LivXowProvider/CNCVerse/java/classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\r\u001a\u00020\u000eHÖ\u0081\u0004J\n\u0010\u000f\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/cncverse/LivXowEventWrapper;", "", "event", "", "<init>", "(Ljava/lang/String;)V", "getEvent", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "LivXowProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class LivXowEventWrapper {

    @NotNull
    private final String event;

    /* JADX WARN: Illegal instructions before constructor call */
    public LivXowEventWrapper() {
        String str = null;
        this(str, 1, str);
    }

    public static /* synthetic */ LivXowEventWrapper copy$default(LivXowEventWrapper livXowEventWrapper, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = livXowEventWrapper.event;
        }
        return livXowEventWrapper.copy(str);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getEvent() {
        return this.event;
    }

    @NotNull
    public final LivXowEventWrapper copy(@NotNull String event) {
        return new LivXowEventWrapper(event);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof LivXowEventWrapper) && Intrinsics.areEqual(this.event, ((LivXowEventWrapper) other).event);
    }

    public int hashCode() {
        return this.event.hashCode();
    }

    @NotNull
    public String toString() {
        return "LivXowEventWrapper(event=" + this.event + ')';
    }

    public LivXowEventWrapper(@NotNull String event) {
        this.event = event;
    }

    public /* synthetic */ LivXowEventWrapper(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str);
    }

    @NotNull
    public final String getEvent() {
        return this.event;
    }
}
