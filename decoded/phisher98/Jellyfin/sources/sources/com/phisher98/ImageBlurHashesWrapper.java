package com.phisher98;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: JellyfinParser.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/Jellyfin/classes.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\"\b\u0003\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003:\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J-\u0010\r\u001a\u00020\u00002\"\b\u0003\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003:\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007HÆ\u0001J\u0014\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0011\u001a\u00020\u0012HÖ\u0081\u0004J\n\u0010\u0013\u001a\u00020\u0004HÖ\u0081\u0004R\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/phisher98/ImageBlurHashesWrapper;", "", "primary", "", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "Primary", "<init>", "(Ljava/util/Map;)V", "getPrimary", "()Ljava/util/Map;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "Jellyfin"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class ImageBlurHashesWrapper {

    @NotNull
    private final Map<String, String> primary;

    /* JADX WARN: Illegal instructions before constructor call */
    public ImageBlurHashesWrapper() {
        Map map = null;
        this(map, 1, map);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ImageBlurHashesWrapper copy$default(ImageBlurHashesWrapper imageBlurHashesWrapper, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            map = imageBlurHashesWrapper.primary;
        }
        return imageBlurHashesWrapper.copy(map);
    }

    @NotNull
    public final Map<String, String> component1() {
        return this.primary;
    }

    @NotNull
    public final ImageBlurHashesWrapper copy(@JsonProperty("Primary") @NotNull Map<String, String> primary) {
        return new ImageBlurHashesWrapper(primary);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof ImageBlurHashesWrapper) && Intrinsics.areEqual(this.primary, ((ImageBlurHashesWrapper) other).primary);
    }

    public int hashCode() {
        return this.primary.hashCode();
    }

    @NotNull
    public String toString() {
        return "ImageBlurHashesWrapper(primary=" + this.primary + ')';
    }

    public ImageBlurHashesWrapper(@JsonProperty("Primary") @NotNull Map<String, String> map) {
        this.primary = map;
    }

    public /* synthetic */ ImageBlurHashesWrapper(Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? MapsKt.emptyMap() : map);
    }

    @NotNull
    public final Map<String, String> getPrimary() {
        return this.primary;
    }
}
