package io.github.tessellator.fnrun;

public interface EventHandler<TEvent, TResult> {
    TResult handle(TEvent request, ExecutionContext context);
}
